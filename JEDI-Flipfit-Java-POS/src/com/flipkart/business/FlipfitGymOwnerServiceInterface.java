package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitUser;

import java.util.List;

public interface FlipfitGymOwnerServiceInterface {

    public void createGymOwner(String name,String email,String phone,String password,String city,String pincode,String username,String pancard,String aadhar, String gst);
    /**
     * Adds a gym center associated with the given user.
     */
    public boolean addGymCenter(FlipFitGymOwner gymOwner,String gym_name,int no_of_slots,String city,String pincode);

    /**
     * Displays the gym centers associated with the given user.
     */
    public void showGymCenters(FlipFitGymOwner gymOwner);

    /**
     * Edits the slots for the gym centers associated with the given user.
     */
    public void editSlots(FlipFitGymOwner gymOwner);
    public boolean editProfile(FlipFitGymOwner gymOwner);

}