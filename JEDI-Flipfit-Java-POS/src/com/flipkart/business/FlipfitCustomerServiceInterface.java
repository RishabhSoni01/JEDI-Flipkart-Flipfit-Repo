package com.flipkart.business;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGyms;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.bean.Booking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface FlipfitCustomerServiceInterface {

    /**
     * Retrieves a list of gyms located in the specified city.
     *
     * @param city The city in which to search for gyms.
     * @return A list of gyms available in the specified city.
     */
    public List<FlipFitGyms> viewGyms(String city);

    // Uncomment to enable slot viewing functionality
    // public List<FlipFitSlot> viewSlots(String gymID);

    /**
     * Creates a new customer profile with the provided details.
     *
     * @param name     The name of the customer.
     * @param email    The email of the customer.
     * @param phone    The phone number of the customer.
     * @param password The password for the customer's account.
     * @param city     The city of the customer.
     * @param pincode  The pincode for the customer's address.
     * @param username The username chosen by the customer.
     */
    public void createCustomer(String name, String email, String phone, String password, String city, String pincode, String username);

    /**
     * Retrieves a list of bookings associated with the specified user.
     *
     * @param userId The ID of the user whose bookings are to be retrieved.
     * @return A list of bookings for the specified user.
     */
    public List<Booking> viewBookings(String userId);

    // Uncomment to enable booking addition functionality
    // public boolean addBooking(String userId, String gymId, String slotId, LocalDate bookingDate, LocalTime bookingTime);

    // Uncomment to enable booking removal functionality
    // public boolean removeBooking(String userId, String gymId, String slotId, LocalDate bookingDate);

    /**
     * Displays the profile information of the specified customer.
     *
     * @param customer The customer whose profile is to be viewed.
     */
    public void viewProfile(FlipFitCustomer customer);

    // Uncomment to enable customer registration functionality
    // public boolean registerCustomer(String username, String password, String email, String city, String phoneNumber, String pincode, String role);

    // Uncomment to enable password change functionality
    // public boolean changePassword(String username, String oldPassword, String newPassword);

    // Uncomment to enable login functionality
    // public boolean login(String username, String password);

    /**
     * Edits the profile information of the specified customer.
     *
     * @param customer The customer whose profile information is to be updated.
     * @return True if the profile was updated successfully; false otherwise.
     */
    public boolean editProfile(FlipFitCustomer customer);
}
