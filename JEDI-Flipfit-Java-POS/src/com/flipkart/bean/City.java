package com.flipkart.bean;

/*
 * @author Mukul
 * @params This class does not have any parameters.
 * @throws This class does not throw any exceptions.
* */
// Represents a city entity.
public class City {
    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    private String cityID;
    private String cityName;

    public City(String cityID, String cityName) {
        this.cityID = cityID;
        this.cityName = cityName;
    }
}