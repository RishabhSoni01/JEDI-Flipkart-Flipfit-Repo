package com.flipkart.bean;

/**
 * Represents an admin user in the FlipFit system, extending FlipFitUser.
 * This class provides a default constructor initializing admin details.
 */
public class FlipFitAdmin extends FlipFitUser {

    /**
     * Default constructor for creating an admin user.
     * Initializes with default values for admin user ID, username, email, password,
     * and assigns the role as ADMIN.
     */
    public FlipFitAdmin() {
        super(101, "admin", "admin@flipfit.com", "8812324234", "password","Bengaluru",4798263,FlipFitRole.ADMIN);
    }
}


