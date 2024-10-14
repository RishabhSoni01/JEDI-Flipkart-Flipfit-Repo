package com.flipkart.dao;

import com.flipkart.bean.FlipFitGyms;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.business.BookingService;
import com.flipkart.bean.Booking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface FlipFitCustomerDAO {

    /**
     * Retrieves a list of bookings associated with a specific user.
     *
     * @param userId the ID of the user whose bookings are to be retrieved
     * @return a List of Booking objects associated with the user
     */
    public List<Booking> viewBookings(String userId);

    /**
     * Adds a new booking to the database.
     *
     * @param booking the Booking object to be added
     * @return true if the booking was added successfully, false otherwise
     */
    public boolean addBooking(Booking booking);

    /**
     * Removes a specific booking from the database based on user ID and slot ID.
     *
     * @param userID the ID of the user whose booking is to be removed
     * @param slotID the ID of the slot associated with the booking
     * @return true if the booking was removed successfully, false otherwise
     */
    public boolean removeBooking(String userID, String slotID);

}

