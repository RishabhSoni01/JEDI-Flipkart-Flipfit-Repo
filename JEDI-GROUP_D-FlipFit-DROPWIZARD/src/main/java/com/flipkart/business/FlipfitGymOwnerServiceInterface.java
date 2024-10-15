package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;

/**
 * @author SreeLakshmi
 *
 * This interface defines operations related to gym owner management,
 * including registration, gym center management, and profile editing.
 */
public interface FlipfitGymOwnerServiceInterface {

    /**
     * Registers a new gym owner with the provided details.
     *
     * @param name,email,phone,password,city,pincode,username,pancard,aadhar,gst
     */
    public void createGymOwner(String name, String email, String phone, String password, String city, String pincode, String username, String pancard, String aadhar, String gst);

    /**
     * Adds a gym center associated with the specified gym owner.
     *
     * @param gymOwner,gym_name,no_of_slots,city,pincode
     * @return True if the gym center was added successfully; false otherwise.
     */
    public boolean addGymCenter(FlipFitGymOwner gymOwner, String gym_name, int no_of_slots, String city, String pincode);

    /**
     * Displays the gym centers associated with the specified gym owner.
     *
     * @param gymOwner
     */
    public void showGymCenters(FlipFitGymOwner gymOwner);

    /**
     * Edits the slots for the gym centers associated with the specified gym owner.
     *
     * @param gymOwner
     */
    public void editSlots(FlipFitGymOwner gymOwner);

    /**
     * Edits the profile information of the specified gym owner.
     *
     * @param gymOwner
     * @return True if the profile was updated successfully; false otherwise.
     */
    public boolean editProfile(FlipFitGymOwner gymOwner);
}
