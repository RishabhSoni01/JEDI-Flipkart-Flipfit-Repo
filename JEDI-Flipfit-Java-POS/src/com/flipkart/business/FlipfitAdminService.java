package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitGyms;

import java.util.List;

public class FlipfitAdminService implements FlipfitAdminServiceInterface{
    @Override
    public boolean approveGymOwner (int gymOwnerId, boolean status){
        return false;
    };
    public List<FlipFitGymOwner> viewPendingGymOwners(){
        return null;
    };
    public List<FlipFitGyms> viewPendingGyms(){
        return null;
    };
    public boolean deleteGyms(int gymId){
        return false;
    };
    public boolean approveGym(int gymId, boolean status)
    {
        return false;
    };
    public boolean deleteGymOwners(int gymOwnerId){
        return false;
    };
    public List<FlipFitGyms> viewGyms(){
        return null;
    };
    public List<FlipFitGyms> viewGymsOwner(int gymOwnerId){
        return null;
    };
    public boolean changePassword(Integer userID, String oldPassword, String newPassword){
        return true;
    };
    public void login(Integer userId, String password,String role){

    };
}
