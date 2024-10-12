package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public interface FlipfitGymOwnerServiceInterface {

    public boolean register(String username, String email, String password, String city,String phoneNumber,String pincode,String aadhar,
                            String panCardNumber, String GST, List<Integer> gymCenterId, String role);
    public boolean addCenter (String userId, String gymId, String city, int numberOfSlots);
    public void editSlots(FlipFitGymOwner flipFitGymOwner);
    public void editProfile(FlipFitGymOwner flipFitGymOwner);
    public boolean changePassword(String username, String oldPassword, String newPassword);
    public boolean login(String username, String password);
}