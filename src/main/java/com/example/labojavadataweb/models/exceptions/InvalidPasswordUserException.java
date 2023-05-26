package com.example.labojavadataweb.models.exceptions;

public class InvalidPasswordUserException extends RuntimeException{

    public InvalidPasswordUserException() {
        super("Wrong password");
    }

    public InvalidPasswordUserException(String message) {
        super(message);
    }
}
