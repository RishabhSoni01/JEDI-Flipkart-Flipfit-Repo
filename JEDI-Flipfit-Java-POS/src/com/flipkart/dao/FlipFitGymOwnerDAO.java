package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitGyms;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.bean.FlipFitUser;

import java.time.LocalDateTime;
import java.util.List;

public interface FlipFitGymOwnerDAO {

    /**
     * Updates the profile information of a gym owner.
     *
     * @param gymOwner the FlipFitGymOwner object containing updated information
     * @return true if the profile was updated successfully, false otherwise
     */
    public boolean updateProfile(FlipFitGymOwner gymOwner);

    /**
     * Retrieves the gym owner associated with a specific user.
     *
     * @param user the FlipFitUser object representing the user
     * @return the corresponding FlipFitGymOwner object
     */
    public FlipFitGymOwner getGymOwner(FlipFitUser user);

    /**
     * Removes a specific time slot from a gym's schedule.
     *
     * @param gymID the ID of the gym from which the slot will be removed
     * @param starttime the start time of the slot to be removed
     */
    public void removeSlot(String gymID, LocalDateTime starttime);

    /**
     * Checks if a specified time slot exists for a given gym.
     *
     * @param gymID the ID of the gym to check
     * @param slot the FlipFitSlot object representing the slot to check
     * @return true if the slot exists, false otherwise
     */
    public boolean isSlotExists(String gymID, FlipFitSlot slot);

    /**
     * Adds a new time slot to a gym's schedule.
     *
     * @param gymID the ID of the gym to which the slot will be added
     * @param slot the FlipFitSlot object representing the new slot
     */
    public void addSlots(String gymID, FlipFitSlot slot);

    /**
     * Retrieves a list of gym centers associated with a specific user.
     *
     * @param userid the ID of the user whose gym centers are to be retrieved
     * @return a List of FlipFitGyms objects associated with the user
     */
    public List<FlipFitGyms> getGymCenters(String userid);

    /**
     * Adds a new gym center to the database.
     *
     * @param gymCenter the FlipFitGyms object representing the new gym center
     * @return true if the gym center was added successfully, false otherwise
     */
    public boolean addGymCenter(FlipFitGyms gymCenter);
}
