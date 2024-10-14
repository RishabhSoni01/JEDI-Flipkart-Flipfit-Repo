package com.flipkart.business;

// Import necessary classes
import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitUser;
import com.flipkart.exception.InvalidLogin;

/**
 * This interface defines the operations related to user management.
 * This includes adding users, user login, password validation, password confirmation,
 * and registration of gym owners and customers.
 */
public interface FlipFitUserInterface {

    /**
     * Adds a new user to the system.
     *
     * @param user The user object containing user details.
     */
    public void addUser(FlipFitUser user);

    /**
     * Authenticates a user with the given username and password.
     *
     * @param username The username of the user trying to log in.
     * @param password The password provided by the user.
     * @return The authenticated user object, or null if authentication fails.
     */
    public FlipFitUser login(String username, String password) throws InvalidLogin;

    /**
     * Validates the user's old password against the stored password.
     *
     * @param user The user whose password is being validated.
     * @param oldPassword The old password provided for validation.
     * @return True if the old password is correct; false otherwise.
     */
    boolean validatePassword(FlipFitUser user, String oldPassword);

    /**
     * Confirms the new password by checking if it matches the confirmation password,
     * and updates the user's password if they match.
     *
     * @param user The user whose password is being changed.
     * @param newPassword The new password to set.
     * @param confirmPassword The confirmation password to validate.
     */
    void confirmPassword(FlipFitUser user, String newPassword, String confirmPassword);
    boolean registerGymOwner(FlipFitGymOwner gymOwner);
    boolean registerCustomer(FlipFitCustomer customer);
}
