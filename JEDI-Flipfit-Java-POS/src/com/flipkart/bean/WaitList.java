package com.flipkart.bean;

import java.util.List;
/*

 * @author Rishabh Soni
 * @params This class does not have any parameters.
 * @throws This class does not throw any exceptions.
 */
public class WaitList {
    public int waitListId;
    public int waitingNumber;
    public int maxCount;
    public List<FlipFitCustomer> waitListCustomer;

    public int getWaitListId() {
        return waitListId;
    }

    public void setWaitListId(int waitListId) {
        this.waitListId = waitListId;
    }

    public int getWaitingNumber() {
        return waitingNumber;
    }

    public void setWaitingNumber(int waitingNumber) {
        this.waitingNumber = waitingNumber;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public List<FlipFitCustomer> getWaitListCustomer() {
        return waitListCustomer;
    }

    public void setWaitListCustomer(List<FlipFitCustomer> waitListCustomer) {
        this.waitListCustomer = waitListCustomer;
    }
}
