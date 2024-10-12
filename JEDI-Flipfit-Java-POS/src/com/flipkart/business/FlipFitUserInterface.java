package com.flipkart.business;

// Import necessary classes
import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitUser;

/**
 This interface defines the operations related to user management.
 This includes adding users, user login, password validation, password confirmation,
 and registration of gym owners and customers.
 */
public interface FlipFitUserInterface {

    /**
     * Adds a new user
     */
    public void addUser(FlipFitUser user);

    /**
     * Authenticates a user with the given username and password.
     */
    public FlipFitUser login(String username, String password);

    boolean validatePassword(FlipFitUser user, String oldPassword);

    void confirmPassword(FlipFitUser user, String newPassword, String confirmPassword);

    boolean registerGymOwner(FlipFitGymOwner gymOwner);

    boolean registerCustomer(FlipFitCustomer customer);


/**
 Validates the user's old password
 */
}
