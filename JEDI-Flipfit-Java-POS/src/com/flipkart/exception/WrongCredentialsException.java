package com.flipkart.exception;

public class WrongCredentialsException extends Exception {
    public WrongCredentialsException() {
        super("Wrong credentials");
    }
}
