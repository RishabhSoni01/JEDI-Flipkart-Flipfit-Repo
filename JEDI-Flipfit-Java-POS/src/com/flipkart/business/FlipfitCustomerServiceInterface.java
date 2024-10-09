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
    public boolean checkValidCustomer (String userName, String password);
    public boolean registerCustomer(String userName, String password, String email, String city, String cardNumber);
    public boolean changePassword(String username, String oldPassword, String newPassword);
    public void login(String userName, String password);
}
