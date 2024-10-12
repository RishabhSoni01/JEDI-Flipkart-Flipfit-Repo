package com.flipkart.bean;

import java.util.List;

/**
 * Represents an admin user in the FlipFit system, extending FlipFitUser.
 * This class provides a default constructor initializing admin details.
 */
public class FlipFitGymOwner extends FlipFitUser {

    /**
     * Default constructor for creating an admin user.
     * Initializes with default values for admin user ID, username, email, password,
     * and assigns the role as ADMIN.
     */
    private String panCard;
    private String aadhar;
    private String GST;

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

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    private List<FlipFitGyms> gymCenters;
    public Boolean isApproved;


    public FlipFitGymOwner(String userID, String name, String email, String phoneNumber, String password, String city, String pincode, int role,String username) {
        super(userID, name, email, phoneNumber, password, city, pincode, role,username);
    }
}

