package com.flipkart.business;

import com.flipkart.bean.FlipFitGyms;
import com.flipkart.bean.FlipFitSlot;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class FlipfitCustomerService implements FlipfitCustomerServiceInterface {
    public List<FlipFitGyms> viewGyms(){

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
    public boolean checkValidCustomer(String userName, String password) {
        return false;
    }

    @Override
    public boolean registerCustomer(String userName, String password, String email, String city, String cardNumber) {
        return false;
    }

    @Override
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        return false;
    }

    @Override
    public void login(String userName, String password) {

    }
}
