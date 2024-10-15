package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;
/**
 * Represents a gym in the FlipFit application.
 * This class contains details about the gym, including its
 * identifier, name, status, owner, location, and available slots.
 *
 * @author JEDI-GroupD
 * @params This class does not have any parameters.
 * @throws this class does not throw any exceptions.

 */
public class FlipFitGyms {

    // Unique identifier for the gym
    private String gymId;

    // Name of the gym
    private String gymName;

    // Total number of slots available in the gym
    private int numberOfSlots;

    // Status of the gym (open/closed)
    private Boolean gymStatus;

    // List of available slots in the gym
    private List<FlipFitSlot> slot;

    // Unique identifier for the owner of the gym
    private String ownerID;

    // City where the gym is located
    private String city;

    // Postal code for the gym's location
    private String pincode;

    /**
     * Constructor to initialize a FlipFitGyms object.
     *
     * @param gymId        Unique identifier for the gym.
     * @param gymName      Name of the gym.
     * @param numberOfSlots Total number of slots in the gym.
     * @param gymStatus    Status of the gym (open/closed).
     * @param owner        Identifier for the gym owner.
     * @param city         City where the gym is located.
     * @param pincode      Postal code for the gym's location.
     * @param slot         List of available slots in the gym.
     */
    public FlipFitGyms(String gymId, String gymName, int numberOfSlots, Boolean gymStatus,
                       String owner, String city, String pincode, List<FlipFitSlot> slot) {
        this.gymId = gymId;
        this.gymName = gymName;
        this.numberOfSlots = numberOfSlots;
        this.gymStatus = gymStatus;
        this.ownerID = owner;
        this.city = city;
        this.pincode = pincode;
        this.slot = slot;
    }

    // Getter methods for each attribute

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

    public List<FlipFitSlot> getSlot() {
        return slot;
    }

    public void setSlot(List<FlipFitSlot> slot) {
        this.slot = slot;
    }

    public String getOwner() {
        return ownerID;
    }

    public void setOwner(String owner) {
        this.ownerID = owner;
    }

    public String getCity() {
        return city;
    }

    public String getPincode() {
        return pincode;
    }
}
