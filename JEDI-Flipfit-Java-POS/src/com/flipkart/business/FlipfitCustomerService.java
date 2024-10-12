package com.flipkart.business;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGyms;
import com.flipkart.bean.FlipFitSlot;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class FlipfitCustomerService implements FlipfitCustomerServiceInterface {
    @Override
    public List<FlipFitGyms> viewGyms(String city){
        return List.of();
    }

    @Override
    public List<FlipFitSlot> viewSlots(String gymID) {
        return List.of();
    }

    @Override
    public List<Booking> viewBookings() {
        return List.of();
    }

    @Override
    public boolean addBooking(String userId, String gymId, String slotId, LocalDate bookingDate, LocalTime bookingTime) {
        return false;
    }

    @Override
    public boolean removeBooking(String userId, String gymId, String slotId, LocalDate bookingDate) {
        return false;
    }

    @Override
    public boolean viewProfile(FlipFitCustomer customer){
        return false;
    };

    @Override
    public boolean registerCustomer(String username, String password, String email, String city, String phoneNumber, String pincode, String role) {
        return false;
    }

    @Override
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        return false;
    }

    @Override
    public boolean login(String username, String password) {
        return false;
    }
}
