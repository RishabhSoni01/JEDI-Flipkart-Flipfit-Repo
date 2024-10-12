package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.business.BookingService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface FlipFitCustomerDAO {
//    public List<FlipFitGyms> viewGyms(String city);
//    public List<FlipFitSlot> viewSlots(String gymID);
    public List<Booking> viewBookings(String userId);
    public boolean addBooking(String userId,String bookingId, String gymId, String slotId);
    public boolean removeBooking(String userId, String gymId, String slotId, LocalDate bookingDate);
    public FlipFitCustomer viewProfile(String userId);
    public boolean registerCustomer(String username, String password, String email, String city, String phoneNumber,String pincode,String role);
    public boolean changePassword(String username, String oldPassword, String newPassword);
    public boolean login(String username, String password);
}
