package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;

/**
 * Author: JEDI-Group D - Flipkart Development
 *
 * This interface defines operations related to gym owner management,
 * including registration, gym center management, and profile editing.
 */
public interface FlipfitGymOwnerServiceInterface {

    /**
     * Registers a new gym owner with the provided details.
     *
     * @param name     The name of the gym owner.
     * @param email    The email address of the gym owner.
     * @param phone    The phone number of the gym owner.
     * @param password The password for the gym owner's account.
     * @param city     The city where the gym owner is located.
     * @param pincode  The pincode for the gym owner's address.
     * @param username The username chosen by the gym owner.
     * @param pancard  The PAN card number of the gym owner.
     * @param aadhar   The Aadhar card number of the gym owner.
     * @param gst      The GST number of the gym owner.
     */
    public void createGymOwner(String name, String email, String phone, String password, String city, String pincode, String username, String pancard, String aadhar, String gst);

    /**
     * Adds a gym center associated with the specified gym owner.
     *
     * @param gymOwner    The gym owner adding the gym center.
     * @param gym_name    The name of the gym center.
     * @param no_of_slots The number of slots available in the gym center.
     * @param city        The city where the gym center is located.
     * @param pincode     The pincode for the gym center's address.
     * @return True if the gym center was added successfully; false otherwise.
     */
    public boolean addGymCenter(FlipFitGymOwner gymOwner, String gym_name, int no_of_slots, String city, String pincode);

    /**
     * Displays the gym centers associated with the specified gym owner.
     *
     * @param gymOwner The gym owner whose gym centers are to be displayed.
     */
    public void showGymCenters(FlipFitGymOwner gymOwner);

    /**
     * Edits the slots for the gym centers associated with the specified gym owner.
     *
     * @param gymOwner The gym owner whose gym slots are to be edited.
     */
    public void editSlots(FlipFitGymOwner gymOwner);

    /**
     * Edits the profile information of the specified gym owner.
     *
     * @param gymOwner The gym owner whose profile is to be updated.
     * @return True if the profile was updated successfully; false otherwise.
     */
    public boolean editProfile(FlipFitGymOwner gymOwner);
}
