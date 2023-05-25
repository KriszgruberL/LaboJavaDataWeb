package com.example.labojavadataweb.repositories.impl;

import com.example.labojavadataweb.models.entities.User;
import com.example.labojavadataweb.repositories.BaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Optional;
import java.util.Set;

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
    public abstract Set<TEntity> getMany();

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
