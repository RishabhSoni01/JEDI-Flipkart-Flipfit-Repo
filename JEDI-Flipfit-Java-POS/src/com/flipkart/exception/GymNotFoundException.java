package com.flipkart.exception;

public class GymNotFoundException extends Exception {
    public GymNotFoundException(int gymId , String gymName) {
        super("Gym " + gymId + " not found for " + gymName);
    }
}
