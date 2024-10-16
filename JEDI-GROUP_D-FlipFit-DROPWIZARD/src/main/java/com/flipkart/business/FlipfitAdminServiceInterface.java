package com.flipkart.business;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitGyms;

import java.util.List;

/**
 * @author Mukul
 *
 * This interface defines the operations for admin management,
 * including approval of gym owners and customers, and retrieving
 * information about gyms and users.
 */
public interface FlipfitAdminServiceInterface {

    /**
     * Approves a gym owner by their ID.
     *
     * @param gymOwnerId
     * @return An object indicating the approval status.
     */
    public Object approveGymOwner(String gymOwnerId);

    /**
     * Retrieves a list of gym owners awaiting approval.
     *
     * @return A list of pending gym owners.
     */
    public List<FlipFitGymOwner> viewPendingGymOwners();

    /**
     * Retrieves a list of gyms that are pending approval.
     *
     * @return A list of pending gyms.
     */
    public List<FlipFitGyms> viewPendingGyms();

    /**
     * Approves a gym by its ID.
     *
     * @param gymId The ID of the gym to be approved.
     */
    public void approveGym(String gymId);

    /**
     * Retrieves a list of all gyms.
     *
     * @return A list of all gyms.
     */
    public List<FlipFitGyms> viewGyms();

    /**
     * Retrieves a list of all gym owners.
     *
     * @return A list of all gym owners.
     */
    public List<FlipFitGymOwner> viewGymsOwner();

    /**
     * Validates the login credentials of an admin.
     *
     * @param username,password
     * @return True if the login is successful, false otherwise.
     */
    public Boolean login(String username, String password);

    /**
     * Retrieves a list of all customers in the system.
     *
     * @return A list of all customers.
     */
    public List<FlipFitCustomer> getAllCustomers();

    /**
     * Retrieves a list of customers who are pending approval.
     *
     * @return A list of pending customers.
     */
    public List<FlipFitCustomer> getPendingCustomers();

    /**
     * Approves a customer by their ID.
     *
     * @param customerId
     * @return A message indicating the approval status.
     */
    public Object approveCustomers(String customerId);
}
