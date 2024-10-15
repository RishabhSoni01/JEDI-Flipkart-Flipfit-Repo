package com.flipkart.business;

// Import necessary classes
import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitUser;
import com.flipkart.exception.InvalidLogin;

/**
 * @author Kabir
 *
 * This interface defines the operations related to user management.
 * This includes adding users, user login, password validation, password confirmation,
 * and registration of gym owners and customers.
 */
public interface FlipFitUserInterface {

    /**
     * Adds a new user to the system.
     *
     * @param user
     */
    public void addUser(FlipFitUser user);

    /**
     * Authenticates a user with the given username and password.
     *
     * @param username,password
     * @return The authenticated user object.
     * @throws InvalidLogin If authentication fails.
     */
    public FlipFitUser login(String username, String password) throws InvalidLogin;

    /**
     * Validates the user's old password against the stored password.
     *
     * @param user,oldPassword
     * @return True if the old password is correct; false otherwise.
     */
    boolean validatePassword(FlipFitUser user, String oldPassword);

    /**
     * Confirms the new password by checking if it matches the confirmation password,
     * and updates the user's password if they match.
     *
     * @param user,newPassword,confirmPassword
     */
    void confirmPassword(FlipFitUser user, String newPassword, String confirmPassword);

    /**
     * Registers a new gym owner in the system.
     *
     * @param gymOwner
     * @return True if registration is successful; false otherwise.
     */
    boolean registerGymOwner(FlipFitGymOwner gymOwner);

    /**
     * Registers a new customer in the system.
     *
     * @param customer
     * @return True if registration is successful; false otherwise.
     */
    boolean registerCustomer(FlipFitCustomer customer);
}
