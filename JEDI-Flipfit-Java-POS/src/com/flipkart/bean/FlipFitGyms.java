package com.flipkart.bean;

import java.util.ArrayList;

public class FlipFitGyms {

    private String gymId;
    private String gymName;
    private int numberOfSlots;
    private Boolean gymStatus;
    private FlipFitGymOwner owner;
    public String getGymId() {
        return gymId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public int getNumberOfSlots() {
        return numberOfSlots;
    }

    public void setNumberOfSlots(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }

    public Boolean getGymStatus() {
        return gymStatus;
    }

    public void setGymStatus(Boolean gymStatus) {
        this.gymStatus = gymStatus;
    }

    public FlipFitGymOwner getOwner() {
        return owner;
    }

    public void setOwner(FlipFitGymOwner owner) {
        this.owner = owner;
    }


}
