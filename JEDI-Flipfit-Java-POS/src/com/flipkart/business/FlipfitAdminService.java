package com.flipkart.business;

import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public class FlipfitAdminService implements FlipfitAdminServiceInterface{
    @Override
    public boolean approveGymOwner(String gymOwnerId, boolean status) {
        return false;
    }

    @Override
    public List<FlipFitGymOwner> viewNonApprovedSlots() {
        return List.of();
    }

    @Override
    public boolean changePassword(String userName, String oldPassword, String newPassword) {
        return false;
    }

    @Override
    public void login(String userName, String password) {

    }
}
