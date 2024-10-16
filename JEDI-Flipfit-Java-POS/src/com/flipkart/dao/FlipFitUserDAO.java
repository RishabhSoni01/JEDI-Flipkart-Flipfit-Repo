package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitUser;
import com.flipkart.exception.InvalidLogin;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.exception.RegistrationFailedException;

/**
 * Interface representing the Data Access Object (DAO) for FlipFit users.
 * This interface defines methods for user-related operations such as validation,
 * registration, and updates. Implementing classes will provide the actual
 * functionality for interacting with the database or other data sources.
 *
 * @author SreeLakshmi
 */
public interface FlipFitUserDAO {

    /**
     * Validates a user's credentials.
     *
     * @param username,password
     * @return A FlipFitUser object if the credentials are valid; otherwise, returns null.
     * @throws InvalidLogin if the credentials are invalid.
     * @throws UserNotFoundException if the user is not found.
     */
    public FlipFitUser validateUser(String username, String password) throws InvalidLogin, UserNotFoundException;

    /**
     * Registers a new gym owner.
     *
     * @param gymOwner The FlipFitGymOwner object containing details of the gym owner.
     * @return True if the registration is successful; false otherwise.
     * @throws RegistrationFailedException if the registration fails.
     */
    public boolean registerGymOwner(FlipFitGymOwner gymOwner) throws RegistrationFailedException;

    /**
     * Registers a new customer.
     *
     * @param customer The FlipFitCustomer object containing details of the customer.
     * @return True if the registration is successful; false otherwise.
     * @throws RegistrationFailedException if the registration fails.
     */
    public boolean registerCustomer(FlipFitCustomer customer) throws RegistrationFailedException;

    /**
     * Updates an existing user's information.
     *
     * @param user The FlipFitUser object containing updated user details.
     * @return True if the update is successful; false otherwise.
     */
    public boolean updateUser(FlipFitUser user);
}
