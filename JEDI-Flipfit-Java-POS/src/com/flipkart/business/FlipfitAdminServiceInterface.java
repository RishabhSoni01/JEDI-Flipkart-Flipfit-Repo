package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitGyms;

import java.util.List;

public interface FlipfitAdminServiceInterface {

    public boolean approveGymOwner (String gymOwnerId, boolean status);
    public List<FlipFitGymOwner> viewPendingGymOwners();
    public List<FlipFitGyms> viewPendingGyms();
    public boolean deleteGyms(String gymId);
    public boolean approveGym(String gymId, boolean status);
    public boolean deleteGymOwners(String gymOwnerId);
    public List<FlipFitGyms> viewGyms();
    public List<FlipFitGyms> viewGymsOwner(String gymOwnerId);
    public boolean changePassword(String username, String oldPassword, String newPassword);
    public boolean login(String username, String password);
}