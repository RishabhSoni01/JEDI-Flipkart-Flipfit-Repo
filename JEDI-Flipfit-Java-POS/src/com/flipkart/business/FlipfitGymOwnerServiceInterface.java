package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public interface FlipfitGymOwnerServiceInterface {

    public boolean register(Integer userId, String email, String password, String city,String phoneNumber,Integer pincode,String aadhar,
                            String panCardNumber, String GST, List<Integer> gymCenterId, String role);
    public boolean addCenter (Integer userId, Integer gymId, String city, int numberOfSlots);
    public void editSlots(FlipFitGymOwner flipFitGymOwner);
    public void editProfile(FlipFitGymOwner flipFitGymOwner);
    public boolean changePassword(Integer userId, String oldPassword, String newPassword);
    public void login(Integer userId, String password,String role);
}