package com.flipkart.business;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGyms;
import com.flipkart.bean.FlipFitSlot;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface FlipfitCustomerServiceInterface {
    public List<FlipFitGyms> viewGyms(String city);
    public List<FlipFitSlot> viewSlots(String gymID);
    public List<Booking> viewBookings();
    public boolean addBooking(String userId, String gymId, String slotId, LocalDate bookingDate, LocalTime bookingTime);
    public boolean removeBooking(String userId, String gymId, String slotId, LocalDate bookingDate);
    public boolean viewProfile(FlipFitCustomer customer);
    public boolean registerCustomer(String username, String password, String email, String city, String phoneNumber,String pincode,String role);
    public boolean changePassword(String username, String oldPassword, String newPassword);
    public boolean login(String username, String password);
}
