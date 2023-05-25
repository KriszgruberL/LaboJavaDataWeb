package com.example.labojavadataweb.repositories.impl;

import com.example.labojavadataweb.models.entities.User;
import com.example.labojavadataweb.repositories.BaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl<TKey, TEntity> implements BaseRepository<TKey, TEntity> {

    protected EntityManagerFactory emf;
    protected EntityManager em;

    public BaseRepositoryImpl() {
        this.emf = Persistence.createEntityManagerFactory("LaboJavaDataWeb");
        this.em = emf.createEntityManager();
    }


    @Override
    public TEntity add(TEntity tEntity) {
        em.getTransaction().begin();
        em.persist(tEntity);
        em.getTransaction().commit();

        return tEntity;
    }

    @Override
    public Optional<TEntity> getOne(TKey id) {
        TEntity tEntity = em.find(getClassName(), id);
        return Optional.ofNullable(tEntity);
    }


    public abstract Class<TEntity> getClassName();

    public abstract List<TEntity> getMany();

    public List<TEntity> getList(TypedQuery<TEntity> query) {
        List<TEntity> list = query.getResultList();
        System.out.println("Résultat(s) reçu : ");
        list.forEach(System.out::println);
        return list;
    }

    @Override
    public void update(TEntity tEntity) {
        em.getTransaction().begin();
        em.merge(tEntity);
        System.out.println("Modification de : " + tEntity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(TKey id) {
        em.getTransaction().begin();
        em.remove(id);
        em.getTransaction().commit();
    }
}
