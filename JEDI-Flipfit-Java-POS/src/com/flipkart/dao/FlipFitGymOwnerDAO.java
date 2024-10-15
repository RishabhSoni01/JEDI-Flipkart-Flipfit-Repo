package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitGyms;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.bean.FlipFitUser;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Interface for operations related to gym owners in the FlipFit application.
 * Provides methods to manage gym owner profiles, gym centers, and time slots.
 *
 * @author Mukul
 */
public interface FlipFitGymOwnerDAO {

    /**
     * Updates the profile information of a gym owner.
     *
     * @param gymOwner the FlipFitGymOwner object containing updated information
     * @return true if the profile was updated successfully, false otherwise
     * @author JEDI GroupD
     */
    public boolean updateProfile(FlipFitGymOwner gymOwner);

    /**
     * Retrieves the gym owner associated with a specific user.
     *
     * @param user the FlipFitUser object representing the user
     * @return the corresponding FlipFitGymOwner object
     * @author JEDI GroupD
     */
    public FlipFitGymOwner getGymOwner(FlipFitUser user);

    /**
     * Removes a specific time slot from a gym's schedule.
     *
     * @param gymID,starttime
     * @author JEDI GroupD
     */
    public void removeSlot(String gymID, LocalDateTime starttime);

    /**
     * Checks if a specified time slot exists for a given gym.
     *
     * @param gymID,slot
     * @return true if the slot exists, false otherwise
     * @author JEDI GroupD
     */
    public boolean isSlotExists(String gymID, FlipFitSlot slot);

    /**
     * Adds a new time slot to a gym's schedule.
     *
     * @param gymID,slot
     * @author JEDI GroupD
     */
    public void addSlots(String gymID, FlipFitSlot slot);

    /**
     * Retrieves a list of gym centers associated with a specific user.
     *
     * @param userid the ID of the user whose gym centers are to be retrieved
     * @return a List of FlipFitGyms objects associated with the user
     * @author JEDI GroupD
     */
    public List<FlipFitGyms> getGymCenters(String userid);

    /**
     * Adds a new gym center to the database.
     *
     * @param gymCenter the FlipFitGyms object representing the new gym center
     * @return true if the gym center was added successfully, false otherwise
     * @author JEDI GroupD
     */
    public boolean addGymCenter(FlipFitGyms gymCenter);
}
