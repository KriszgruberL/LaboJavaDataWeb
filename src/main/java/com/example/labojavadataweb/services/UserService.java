package com.example.labojavadataweb.services;

import com.example.labojavadataweb.models.entities.User;
import com.example.labojavadataweb.models.forms.UserRegisterForm;

public interface UserService {

    User login(User newUser);
    User register(UserRegisterForm user);
}


