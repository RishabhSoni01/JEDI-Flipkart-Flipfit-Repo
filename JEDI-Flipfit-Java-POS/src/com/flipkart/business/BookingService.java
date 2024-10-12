package com.flipkart.business;

public class BookingService implements BookingInterface{
    @Override
    public boolean addBooking(String userId, String slotId, String gymId) {
        return false;
    }

    @Override
    public boolean checkValidBooking(String slotId, String gymId) {
        return false;
    }

    @Override
    public boolean cancelBooking(String bookingId) {
        return false;
    }
}
