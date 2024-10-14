package com.flipkart.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String username) {
        super("User with username " + username + " not found");
    }
}
