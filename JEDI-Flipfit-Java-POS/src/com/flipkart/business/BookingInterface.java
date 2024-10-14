package com.flipkart.business;

import com.flipkart.bean.FlipFitGyms;
import com.flipkart.bean.FlipFitSlot;

/*
 * @author Mukul Goyal
 * @params This interface does not have any parameters.
 * @throws This interface does not throw any exceptions.
 */
public interface BookingInterface {

    /**
     * Adds a booking for a specified user, gym, and time slot.
     *
     * @param userId The ID of the user making the booking.
     * @param gyms The gym object representing the selected gym.
     * @param slot The time slot object representing the chosen time slot.
     * @return true if the booking is successfully added, false otherwise.
     */
    public boolean addBooking(String userId, FlipFitGyms gyms, FlipFitSlot slot);

    /**
     * Checks whether a specified time slot at a specified gym is valid for booking.
     *
     * @param slotId The ID of the slot being checked.
     * @param gymId The ID of the gym being checked.
     * @return true if the booking is valid, false otherwise.
     */
    public boolean checkValidBooking(String slotId, String gymId);

    /**
     * Cancels an existing booking based on its ID.
     *
     * @param userID The ID of the user booking to be canceled.
     * @return true if the cancellation is successful, false otherwise.
     */
    public boolean cancelBooking(String userID, String slotID);
}
