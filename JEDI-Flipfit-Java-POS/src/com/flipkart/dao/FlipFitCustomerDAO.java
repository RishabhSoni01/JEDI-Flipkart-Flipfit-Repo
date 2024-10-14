package com.flipkart.dao;

import com.flipkart.bean.FlipFitGyms;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.business.BookingService;
import com.flipkart.bean.Booking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface FlipFitCustomerDAO {
//    public List<FlipFitGyms> viewGyms(String city);
//    public List<FlipFitSlot> viewSlots(String gymID);
    public List<Booking> viewBookings(String userId);
    public boolean addBooking(Booking booking);
    public boolean removeBooking(String userID, String slotID);
//    public boolean viewProfile(com.flipkart.bean.FlipFitCustomer customer);
//    public boolean changePassword(String username, String oldPassword, String newPassword);
//    public boolean login(String username, String password);
}
