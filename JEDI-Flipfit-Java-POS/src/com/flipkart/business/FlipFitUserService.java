package com.flipkart.business;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitUser;

public class FlipFitUserService {
    public void addUser(FlipFitUser user){

    };

    /**
     * Authenticates a user with the given username and password.
     */
    public FlipFitUser login(String username, String password){
        return null;
    };

    boolean validatePassword(FlipFitUser user, String oldPassword){
        return false;
    };

    void confirmPassword(FlipFitUser user, String newPassword, String confirmPassword){

    };

    boolean registerGymOwner(FlipFitGymOwner gymOwner){
        return false;
    };

    boolean registerCustomer(FlipFitCustomer customer){
        return false;
    };
}
