package com.flipkart.business;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGyms;
import com.flipkart.bean.FlipFitSlot;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface FlipfitCustomerServiceInterface {
    public List<FlipFitGyms> viewGyms();
    public List<FlipFitSlot> viewSlots();
    public List<Booking> viewBookings();
    public boolean addBooking(Integer userId, Integer gymId, Integer slotId, LocalDate bookingDate, LocalTime bookingTime);
    public boolean removeBooking(Integer userId, Integer gymId, Integer slotId, LocalDate bookingDate);
    public boolean viewProfile(FlipFitCustomer customer);
    public boolean registerCustomer(Integer userId, String password, String email, String city, String phoneNumber,Integer pincode,String role);
    public boolean changePassword(Integer userId, String oldPassword, String newPassword);
    public void login(Integer userId, String password,String role);
}
