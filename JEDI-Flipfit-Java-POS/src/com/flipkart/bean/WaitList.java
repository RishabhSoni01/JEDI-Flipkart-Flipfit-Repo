package com.flipkart.bean;

import java.util.List;

public class WaitList {
    public int waitListId;
    public int userId;
    public int slotId;
    public int waitingNumber;
    public int maxCount;
    public List<FlipFitCustomer> waitListCustomer;

    public int getWaitListId() {
        return waitListId;
    }

    public void setWaitListId(int waitListId) {
        this.waitListId = waitListId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
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
