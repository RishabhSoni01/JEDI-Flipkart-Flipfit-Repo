package com.flipkart.bean;

import java.util.List;
import java.util.ArrayList;

public class FlipFitGymOwner {
    public String panId;
    private String gstNum;
    private String aadharNumber;
    public boolean isApproved;
    ArrayList<String> gymLists = new ArrayList<>();

    public ArrayList<String> getGymLists() {
        return gymLists;
    }

    public void setGymLists(ArrayList<String> gymLists) {
        this.gymLists = gymLists;
    }

    public String getPanId() {
        return panId;
    }

    public void setPanId(String panId) {
        this.panId = panId;
    }

    public String getGSTNum() {
        return gstNum;
    }

    public void setGSTIN(String gstNum) {
        this.gstNum = gstNum;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public boolean addUser() {
        return true;
    }

    public boolean registerGyms() {
        return true;
    }

    public boolean addSlots() {
        return true;
    }

    public boolean viewCenters() {
        return true;
    }
}
