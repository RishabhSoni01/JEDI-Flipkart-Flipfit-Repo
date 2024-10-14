package com.flipkart.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(int userId) {
        super("User with id " + userId + " not found");
    }
}
