package com.flipkart.bean;

import java.util.List;
/*
 * @author Khushi Srivastava
 * @params This class does not have any parameters.
 * @throws This class does not throw any exceptions.
/**
 * Represents a gym owner in the FlipFit system, extending the FlipFitUser class.
 * This class includes additional attributes specific to gym owners, such as
 * identification and approval status.
 */
public class FlipFitGymOwner extends FlipFitUser {

    // PAN card number of the gym owner
    private String panCard;

    // Aadhar card number of the gym owner
    private String aadhar;

    // GST registration number of the gym owner
    private String GST;

    // List of gyms owned by the gym owner
    private List<FlipFitGyms> gymCenters;

    // Approval status of the gym owner (1 for approved, 0 for not approved)
    public int isApproved;

    /**
     * Constructor to create a FlipFitGymOwner object with required details.
     *
     * @param userID      Unique identifier for the gym owner.
     * @param name        Name of the gym owner.
     * @param email       Email address of the gym owner.
     * @param phoneNumber Phone number of the gym owner.
     * @param password    Password for the gym owner's account.
     * @param city        City where the gym owner is located.
     * @param pincode     Postal code for the gym owner's location.
     * @param role        Role identifier (specifically for gym owners).
     * @param username    Username for login purposes.
     * @param panCard     PAN card number of the gym owner.
     * @param aadhar      Aadhar card number of the gym owner.
     * @param GST         GST registration number of the gym owner.
     */
    public FlipFitGymOwner(String userID, String name, String email, String phoneNumber,
                           String password, String city, String pincode, int role,
                           String username, String panCard, String aadhar, String GST) {
        super(userID, name, email, phoneNumber, password, city, pincode, role, username);
        this.panCard = panCard;
        this.aadhar = aadhar;
        this.GST = GST;
    }

    // Getter and setter methods for the attributes

    public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getGST() {
        return GST;
    }

    public void setGST(String GST) {
        this.GST = GST;
    }

    public List<FlipFitGyms> getGymCenters() {
        return gymCenters;
    }

    public void setGymCenters(List<FlipFitGyms> gymCenters) {
        this.gymCenters = gymCenters;
    }

    public int getApproved() {
        return isApproved;
    }

    public void setApproved(int approved) {
        isApproved = approved;
    }
}
