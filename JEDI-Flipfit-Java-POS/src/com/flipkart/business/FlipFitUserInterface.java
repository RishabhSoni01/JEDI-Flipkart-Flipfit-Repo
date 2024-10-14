package com.flipkart.business;

// Import necessary classes
import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitUser;

/**
 * This interface defines the operations related to user management.
 * This includes adding users, user login, password validation, password confirmation,
 * and registration of gym owners and customers.
 */
public interface FlipFitUserInterface {

    /**
     * Adds a new user.
     * @param user The FlipFitUser object to be added.
     */
    public void addUser(FlipFitUser user);

    /**
     * Authenticates a user with the given username and password.
     * @param username The username of the user.
     * @param password The password of the user.
     * @return The authenticated FlipFitUser object or null if authentication fails.
     */
    public FlipFitUser login(String username, String password);

    /**
     * Validates the user's old password.
     * @param user The FlipFitUser object whose password is being validated.
     * @param oldPassword The old password to validate.
     * @return true if the old password matches, false otherwise.
     */
    boolean validatePassword(FlipFitUser user, String oldPassword);

    /**
     * Confirms the new password by checking it against the confirmed password.
     * @param user The FlipFitUser object whose password is being changed.
     * @param newPassword The new password to set.
     * @param confirmPassword The password for confirmation.
     */
    void confirmPassword(FlipFitUser user, String newPassword, String confirmPassword);

    /**
     * Registers a new gym owner.
     * @param gymOwner The FlipFitGymOwner object to be registered.
     * @return true if registration is successful, false otherwise.
     */
    boolean registerGymOwner(FlipFitGymOwner gymOwner);

    /**
     * Registers a new customer.
     * @param customer The FlipFitCustomer object to be registered.
     * @return true if registration is successful, false otherwise.
     */
    boolean registerCustomer(FlipFitCustomer customer);
}
