package com.flipkart.bean;

import java.util.ArrayList;

public class FlipFitGyms extends FlipFitGymOwner {
    private int gymId;

    private String gymName;

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

}
