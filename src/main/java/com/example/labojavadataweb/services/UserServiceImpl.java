package com.example.labojavadataweb.services;

import com.example.labojavadataweb.models.entities.User;
import com.example.labojavadataweb.models.exceptions.InvalidPasswordUserException;
import com.example.labojavadataweb.models.forms.UserRegisterForm;
import com.example.labojavadataweb.repositories.UserRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityNotFoundException;
import org.mindrot.jbcrypt.BCrypt;

import java.io.Serializable;

@Named
@SessionScoped
public class UserServiceImpl implements UserService,Serializable {

    @Inject
    private UserRepository userRepository;

    @Override
    public User login(User newUser) {
        String login = newUser.getUsername();
        User user = userRepository.findByLogin(login);

        if(user == null){
            throw new EntityNotFoundException();
        }

        if (!BCrypt.checkpw(newUser.getPassword(), user.getPassword())) {
            throw new InvalidPasswordUserException();
        }
        return user;
    }

    @Override
    public User register(UserRegisterForm user) {

        if (user.getUsername().trim().equals(""))
            throw new RuntimeException();
        if (user.getPassword().trim().equals(""))
            throw new RuntimeException();

        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));

        return userRepository.add(user.toEntity());
    }
}


