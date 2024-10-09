package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public class FlipfitGymOwnerService implements FlipfitGymOwnerServiceInterface {

    @Override
    public boolean register(Integer userId, String email, String password, String city,String phoneNumber,Integer pincode, String aadhar,String panCardNumber,String GST, List<Integer> gymCenters,String role) {
        return false;
    }

    @Override
    public boolean addCenter(Integer userId, Integer gymId, String city, int numberOfSlots) {
        return false;
    }

    @Override
    public void editSlots(FlipFitGymOwner flipFitGymOwner){
    }
    @Override
    public void editProfile(FlipFitGymOwner flipFitGymOwner){

    };
    @Override
    public boolean changePassword(Integer userId, String oldPassword, String newPassword) {
        return false;
    }

    @Override
    public void login(Integer userId, String password, String role) {

    }
}
