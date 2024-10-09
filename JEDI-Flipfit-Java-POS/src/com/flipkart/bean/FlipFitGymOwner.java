package com.flipkart.bean;

/**
 * Represents an admin user in the FlipFit system, extending FlipFitUser.
 * This class provides a default constructor initializing admin details.
 */
public class FlipFitGymOwner extends FlipFitUser {

    /**
     * Default constructor for creating an admin user.
     * Initializes with default values for admin user ID, username, email, password,
     * and assigns the role as ADMIN.
     */
    public FlipFitGymOwner() {
        super(102, "owner", "owner@flipfit.com", "8812344234", "password2","Bengaluru",4798234,FlipFitRole.GYM_OWNER);
    }
}

