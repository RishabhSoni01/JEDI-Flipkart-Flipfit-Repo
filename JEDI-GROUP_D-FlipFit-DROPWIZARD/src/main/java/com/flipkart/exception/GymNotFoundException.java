package com.flipkart.exception;

public class GymNotFoundException extends Exception {
    public GymNotFoundException(String gymName) {
        super("Gym " + gymName + " not found " );
    }
}
