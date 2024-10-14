package com.flipkart.exception;
/*
* Exception when the booking fails
* */
public class BookingFailedException extends Exception {
    public BookingFailedException(String message) {
        super(message);
    }
}
