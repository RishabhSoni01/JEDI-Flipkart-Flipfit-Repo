package com.flipkart.business;

import com.flipkart.bean.FlipFitGyms;
import com.flipkart.bean.FlipFitSlot;

/**
 * This interface defines the operations related to booking management,
 * including adding, validating, and canceling bookings.
 *
 * @author Khushi
 *
 */
public interface BookingInterface {

    /**
     * Adds a booking for a specified user, gym, and time slot.
     *
     * @param userId,gyms,slot
     * @return true if the booking is successfully added, false otherwise.
     */
    public boolean addBooking(String userId, FlipFitGyms gyms, FlipFitSlot slot);

    /**
     * Checks whether a specified time slot at a specified gym is valid for booking.
     *
     * @param slotId,gymId
     * @return true if the booking is valid, false otherwise.
     */
    public boolean checkValidBooking(String slotId, String gymId);

    /**
     * Cancels an existing booking based on its ID.
     *
     * @param userID,slotID
     * @return true if the cancellation is successful, false otherwise.
     */
    public boolean cancelBooking(String userID, String slotID);
}
