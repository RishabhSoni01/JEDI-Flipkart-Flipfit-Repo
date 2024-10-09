package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;
import java.util.List;

public interface FlipfitAdminServiceInterface {

    public boolean approveGymOwner (String gymOwnerId, boolean status);
    public List<FlipFitGymOwner> viewNonApprovedSlots();
    public boolean changePassword(String userName, String oldPassword, String newPassword);
    public void login(String userName, String password);
}