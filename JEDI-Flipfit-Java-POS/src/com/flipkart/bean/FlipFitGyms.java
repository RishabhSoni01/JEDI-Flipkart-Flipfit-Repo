package com.flipkart.bean;

import java.util.ArrayList;

public class FlipFitGyms extends FlipFitGymOwner {
    private int gymId;
    private String gymName;

    public boolean rquestApproval(){
        return true;
    }

    @Override
    public ArrayList<String> getGymLists() {
        return super.getGymLists();
    }

    @Override
    public void setGymLists(ArrayList<String> gymLists) {
        super.setGymLists(gymLists);
    }

    @Override
    public String getPanId() {
        return super.getPanId();
    }

    @Override
    public void setPanId(String panId) {
        super.setPanId(panId);
    }

    @Override
    public String getGSTNum() {
        return super.getGSTNum();
    }

    @Override
    public void setGSTIN(String gstNum) {
        super.setGSTIN(gstNum);
    }

    @Override
    public String getAadharNumber() {
        return super.getAadharNumber();
    }

    @Override
    public void setAadharNumber(String aadharNumber) {
        super.setAadharNumber(aadharNumber);
    }

    @Override
    public boolean getIsApproved() {
        return super.getIsApproved();
    }

    @Override
    public void setIsApproved(boolean isApproved) {
        super.setIsApproved(isApproved);
    }

    @Override
    public boolean addUser() {
        return super.addUser();
    }

    @Override
    public boolean registerGyms() {
        return super.registerGyms();
    }

    @Override
    public boolean addSlots() {
        return super.addSlots();
    }

    @Override
    public boolean viewCenters() {
        return super.viewCenters();
    }
}
