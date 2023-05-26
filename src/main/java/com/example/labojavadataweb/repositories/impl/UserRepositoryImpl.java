package com.example.labojavadataweb.repositories.impl;

import com.example.labojavadataweb.models.entities.User;
import com.example.labojavadataweb.repositories.UserRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.TypedQuery;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UserRepositoryImpl extends BaseRepositoryImpl<Long, User> implements UserRepository, Serializable {


    @Override
    public Class<User> getClassName() {
        return User.class;
    }

    @Override
    public List<User> getMany() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return getList(query);
    }



    @Override
    public User findByLogin(String login) {
        TypedQuery<User> query = em.createQuery("select  u from User u where username = lower(u.username) or email = lower(u.email)", User.class);
        query.setParameter("name", login);
        query.setParameter("email", login);
        User u = query.getSingleResult();
        System.out.println(u);

        return u;
    }
}
