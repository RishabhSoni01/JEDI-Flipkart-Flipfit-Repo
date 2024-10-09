package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitGyms;

import java.util.List;

public interface FlipfitAdminServiceInterface {

    public boolean approveGymOwner (int gymOwnerId, boolean status);
    public List<FlipFitGymOwner> viewPendingGymOwners();
    public List<FlipFitGyms> viewPendingGyms();
    public boolean deleteGyms(int gymId);
    public boolean approveGym(int gymId, boolean status);
    public boolean deleteGymOwners(int gymOwnerId);
    public List<FlipFitGyms> viewGyms();
    public List<FlipFitGyms> viewGymsOwner(int gymOwnerId);
    public boolean changePassword(Integer userId, String oldPassword, String newPassword);
    public void login(Integer userId, String password,String role);
}