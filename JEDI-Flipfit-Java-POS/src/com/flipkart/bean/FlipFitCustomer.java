package com.flipkart.bean;

/**
 * Represents an admin user in the FlipFit system, extending FlipFitUser.
 * This class provides a default constructor initializing admin details.
 */
public class FlipFitCustomer extends FlipFitUser {

    /**
     * Default constructor for creating an admin user.
     * Initializes with default values for admin user ID, username, email, password,
     * and assigns the role as ADMIN.
     */
    public FlipFitCustomer() {
        super(101, "customer", "customer@flipfit.com", "8812232234", "password3","Bengaluru",23798263,FlipFitRole.CUSTOMER);
    }
}

