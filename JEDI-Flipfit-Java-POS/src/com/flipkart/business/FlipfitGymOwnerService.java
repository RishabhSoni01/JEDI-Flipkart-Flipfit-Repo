package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public class FlipfitGymOwnerService implements FlipfitGymOwnerServiceInterface {

    @Override
    public boolean register(String username, String email, String password, String city,String phoneNumber,String pincode, String aadhar,String panCardNumber,String GST, List<Integer> gymCenters,String role) {
        return false;
    }

    @Override
    public boolean addCenter(String userId, String gymId, String city, int numberOfSlots) {
        return false;
    }

    @Override
    public void editSlots(FlipFitGymOwner flipFitGymOwner){
    }
    @Override
    public void editProfile(FlipFitGymOwner flipFitGymOwner){

    };
    @Override
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        return false;
    }

    @Override
    public boolean login(String username, String password) {
        return false;
    }
}
