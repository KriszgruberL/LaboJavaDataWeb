package com.example.labojavadataweb.repositories.impl;

import com.example.labojavadataweb.models.entities.User;
import com.example.labojavadataweb.repositories.UserRepository;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserRepositoryImpl extends BaseRepositoryImpl<Long, User> implements UserRepository {


    @Override
    public Class<User> getClassName() {
        return User.class;
    }

    @Override
    public List<User> getMany() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return getList(query);
    }



}
