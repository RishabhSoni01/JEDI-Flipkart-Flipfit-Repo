package com.flipkart.dao;

import java.util.List;
import com.flipkart.bean.*;

/**
 * Interface for administrative operations related to gym owners, gyms, and customers.
 * Provides methods to approve requests and retrieve information about pending and approved entities.
 *
 * @author Mukul
 */
public interface FlipFitAdminDAO {

    /**
     * Approves a gym owner request by updating their status in the database.
     *
     * @param gymOwnerId the ID of the gym owner to be approved.
     * @return true if the approval was successful, false otherwise.
     */
    public boolean approveGymOwner(String gymOwnerId);

    /**
     * Approves a customer request by updating their status in the database.
     *
     * @param customerId the ID of the customer to be approved.
     * @return true if the approval was successful, false otherwise.
     */
    public boolean approveCustomer(String customerId);

    /**
     * Retrieves a list of all pending gym owner requests.
     *
     * @return a list of FlipFitGymOwner objects representing gym owners awaiting approval.
     */
    public List<FlipFitGymOwner> getPendingGymOwners();

    /**
     * Retrieves a list of all pending gym requests.
     *
     * @return a list of FlipFitGyms objects representing gyms awaiting approval.
     */
    public List<FlipFitGyms> getPendingGymCenters();

    /**
     * Approves a gym request by updating its status in the database.
     *
     * @param gymId the ID of the gym to be approved.
     * @return true if the approval was successful, false otherwise.
     */
    public boolean approveGymCenter(String gymId);

    /**
     * Retrieves a list of all gyms in the system.
     *
     * @return a list of FlipFitGyms objects representing all gyms.
     */
    public List<FlipFitGyms> getAllGymCenters();

    /**
     * Retrieves a list of all gym owners.
     *
     * @return a list of FlipFitGymOwner objects associated with the gym owners.
     */
    public List<FlipFitGymOwner> getAllGymOwners();

    /**
     * Retrieves a list of all customers in the system.
     *
     * @return a list of FlipFitCustomer objects representing all customers.
     */
    public List<FlipFitCustomer> getAllCustomers();

    /**
     * Retrieves a list of all pending customer requests.
     *
     * @return a list of FlipFitCustomer objects representing pending customer requests.
     */
    public List<FlipFitCustomer> getPendingCustomers();
}
