package com.flipkart.business;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGyms;
import com.flipkart.bean.FlipFitSlot;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class FlipfitCustomerService implements FlipfitCustomerServiceInterface {
    @Override
    public List<FlipFitGyms> viewGyms(){
        return List.of();
    }

    @Override
    public List<FlipFitSlot> viewSlots() {
        return List.of();
    }

    @Override
    public List<Booking> viewBookings() {
        return List.of();
    }

    @Override
    public boolean addBooking(Integer userId, Integer gymId, Integer slotId, LocalDate bookingDate, LocalTime bookingTime) {
        return false;
    }

    @Override
    public boolean removeBooking(Integer userId, Integer gymId, Integer slotId, LocalDate bookingDate) {
        return false;
    }

    @Override
    public boolean viewProfile(FlipFitCustomer customer){
        return false;
    };

    @Override
    public boolean registerCustomer(Integer userId, String password, String email, String city, String phoneNumber, Integer pincode, String role) {
        return false;
    }

    @Override
    public boolean changePassword(Integer userId, String oldPassword, String newPassword) {
        return false;
    }

    @Override
    public void login(Integer userId, String password, String role) {

    }
}
