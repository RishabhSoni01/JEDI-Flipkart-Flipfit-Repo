package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitGyms;

import java.util.List;

public class FlipfitAdminService implements FlipfitAdminServiceInterface{
    @Override
    public boolean approveGymOwner (String gymOwnerId, boolean status){
        return false;
    };
    public List<FlipFitGymOwner> viewPendingGymOwners(){
        return null;
    };
    public List<FlipFitGyms> viewPendingGyms(){
        return null;
    };
    public boolean deleteGyms(String gymId){
        return false;
    };
    public boolean approveGym(String gymId, boolean status)
    {
        return false;
    };
    public boolean deleteGymOwners(String gymOwnerId){
        return false;
    };
    public List<FlipFitGyms> viewGyms(){
        return null;
    };
    public List<FlipFitGyms> viewGymsOwner(String gymOwnerId){
        return null;
    };
    public boolean changePassword(String username, String oldPassword, String newPassword){
        return true;
    };
    public boolean login(String username, String password){
        return false;
    };
}
