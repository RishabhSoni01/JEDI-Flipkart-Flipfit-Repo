package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.dao.*;
import java.time.LocalDateTime;
import java.util.UUID;

public class BookingService implements BookingInterface{
    // Service for customer-related operations
    private FlipfitCustomerService customerService = new FlipfitCustomerService();

    // DAO implementation for customer data access
    private FlipFitCustomerDAOImplement customerDAO = new FlipFitCustomerDAOImplement();

    /**
     * Adds a booking for a user if the specified slot is available.
     *
     * @param userId The ID of the user making the booking.
     * @param gym The gym object representing the selected gym.
     * @param slot The time slot object representing the chosen time slot.
     * @return true if the booking is successfully added, false otherwise.
     */
    public boolean addBooking(String userId, FlipFitGyms gym, FlipFitSlot slot) {
        // Generate a unique booking ID
        String booking_id = UUID.randomUUID().toString();

        // Get the booking date from the slot's start time
        LocalDateTime bookingDate = slot.getStartTime();

        // Create a new booking instance
        Booking newBooking = new Booking(userId, booking_id, gym.getGymId(), slot.getSlotId(), bookingDate);

        // Check if there are available seats in the slot
        if (slot.getSeatsAvailable() > 0) {
            // Check if a booking already exists for the user in the same slot
            if (customerDAO.bookingExists(newBooking)) {
                // Attempt to cancel the previous overlapping booking
                if (cancelBooking(newBooking.getUserID(), slot.getSlotId())) {
                    System.out.println("Previous overlapping booking is cancelled.");
                } else {
                    System.out.println("Previous overlapping booking cancellation error.");
                }
            }

            // Add the new booking to the database
            if (customerDAO.addBooking(newBooking)) {
                // Update the available capacity for the slot
                customerDAO.updateCapacity(newBooking.getSlotID(), -1);
                System.out.println("Confirm booking at " + gym.getGymName() + " " + slot.getSlotId() + " successfully added.");
                return true;
            }
            // TODO: Implement waitlist functionality here
            else return false;
        }
        return false; // Return false if no seats are available
    }

    /**
     * Checks if a booking is valid for a given slot and gym.
     * Currently not implemented.
     *
     * @param slotId The ID of the slot to check.
     * @param gymId The ID of the gym to check.
     * @return false as this method is not yet implemented.
     */
    public boolean checkValidBooking(String slotId, String gymId) {
        return false; // Placeholder implementation
    }

    /**
     * Cancels an existing booking based on user ID and slot ID.
     *
     * @param userID The ID of the user whose booking is to be canceled.
     * @param slotID The ID of the slot to be canceled.
     * @return true if the booking was successfully canceled, false otherwise.
     */
    public boolean cancelBooking(String userID, String slotID) {
        // Call DAO to remove the booking
        return customerDAO.removeBooking(userID, slotID);
    }
}
