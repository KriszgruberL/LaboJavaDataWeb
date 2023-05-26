package com.example.labojavadataweb.repositories;

import com.example.labojavadataweb.models.entities.User;



public interface UserRepository extends BaseRepository<Long, User> {

    User findByLogin(String login);
}
