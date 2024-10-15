package com.flipkart.exception;

public class GymOwnerNotFoundException extends RuntimeException {
    public GymOwnerNotFoundException(String message) {
        super(message);
    }
}
