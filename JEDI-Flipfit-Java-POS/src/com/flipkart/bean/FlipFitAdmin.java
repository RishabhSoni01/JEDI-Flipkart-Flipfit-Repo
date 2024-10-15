package com.flipkart.bean;

/**
 * Represents an admin user in the FlipFit system, extending FlipFitUser.
 * This class provides a default constructor initializing admin details.
 *
 * @author SreeLakshmi
 *
 */
public class FlipFitAdmin extends FlipFitUser {

    /**
     * Default constructor for creating an admin user.
     *
     * @param userId,name,email,phoneNumber,password,city,pincode,roleid,username
     */
    public FlipFitAdmin(String userId, String name, String email, String phoneNumber, String password, String city, String pincode, Integer roleid, String username) {
        super(userId, name, email, phoneNumber, password, city, pincode, roleid, username);
    }
}


