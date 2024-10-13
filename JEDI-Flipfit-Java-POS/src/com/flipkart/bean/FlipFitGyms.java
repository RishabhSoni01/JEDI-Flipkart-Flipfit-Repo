package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

public class FlipFitGyms {

    private String gymId;
    private String gymName;
    private int numberOfSlots;
    private Boolean gymStatus;

    public List<FlipFitSlot> getSlot() {
        return slot;
    }

    public void setSlot(List<FlipFitSlot> slot) {
        this.slot = slot;
    }

    private List<FlipFitSlot> slot;
    public FlipFitGyms(String gymId, String gymName, int numberOfSlots, Boolean gymStatus, String owner, String city, String pincode, List<FlipFitSlot> slot) {
        this.gymId = gymId;
        this.gymName = gymName;
        this.numberOfSlots = numberOfSlots;
        this.gymStatus = gymStatus;
        this.ownerID = owner;
        this.city = city;
        this.pincode = pincode;
        this.slot=slot;
    }

    private String ownerID;
    private String city;
    private String pincode;
    public String getPincode() {
        return pincode;
    }

    public String getCity() {
        return city;
    }
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

    public String getOwner() {
        return ownerID;
    }

    public void setOwner(String owner) {
        this.ownerID = owner;
    }


}
