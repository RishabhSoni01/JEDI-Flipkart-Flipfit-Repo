package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGyms;

import java.util.List;

/**
 * @author Manali
 *
 * This interface defines the operations for customer management,
 * including viewing gyms, creating customer profiles, and managing bookings.
 */
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
     * @param name,email,phone,password,city,pincode,username
     */
    public void createCustomer(String name, String email, String phone, String password, String city, String pincode, String username);

    /**
     * Retrieves a list of bookings associated with the specified user.
     *
     * @param userId
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
     * @param customer
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
     * @param customer
     * @return True if the profile was updated successfully; false otherwise.
     */
    public boolean editProfile(FlipFitCustomer customer);
    /**
     * Retrieves a customer by their ID.
     *
     * @param userId The ID of the customer to retrieve.
     * @return The customer object, or null if not found.
     */
    public FlipFitCustomer getCustomerById(String userId);
}
