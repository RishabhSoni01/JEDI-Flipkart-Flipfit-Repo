package com.flipkart.bean;

import java.util.List;

/**
 * Represents a waitlist for gym bookings.
 * This class keeps track of customers waiting for a slot in a gym when it reaches full capacity.
 *
 * @author JEDI-GroupD
 * @params This class does not have any parameters.
 * @throws this class does not throw any exceptions.
 */
public class WaitList {
    // Unique identifier for the waitlist.
    private int waitListId;

    // The current waiting number of the customer.
    private int waitingNumber;

    // The maximum count of customers allowed in the waitlist.
    private int maxCount;

    // The list of customers currently in the waitlist.
    private List<FlipFitCustomer> waitListCustomer;

    /**
     * Gets the unique identifier for the waitlist.
     *
     * @return the waitListId.
     */
    public int getWaitListId() {
        return waitListId;
    }

    /**
     * Sets the unique identifier for the waitlist.
     *
     * @param waitListId the unique identifier to set.
     */
    public void setWaitListId(int waitListId) {
        this.waitListId = waitListId;
    }

    /**
     * Gets the current waiting number of the customer.
     *
     * @return the waitingNumber.
     */
    public int getWaitingNumber() {
        return waitingNumber;
    }

    /**
     * Sets the current waiting number of the customer.
     *
     * @param waitingNumber the waiting number to set.
     */
    public void setWaitingNumber(int waitingNumber) {
        this.waitingNumber = waitingNumber;
    }

    /**
     * Gets the maximum count of customers allowed in the waitlist.
     *
     * @return the maxCount.
     */
    public int getMaxCount() {
        return maxCount;
    }

    /**
     * Sets the maximum count of customers allowed in the waitlist.
     *
     * @param maxCount the maximum count to set.
     */
    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    /**
     * Gets the list of customers currently in the waitlist.
     *
     * @return the list of waitlist customers.
     */
    public List<FlipFitCustomer> getWaitListCustomer() {
        return waitListCustomer;
    }

}
