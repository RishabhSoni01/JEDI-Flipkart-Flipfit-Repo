package com.flipkart.bean;

/**
 * Represents a city entity within the Flipkart application.
 * This class holds the information regarding a city including its ID and name.
 *
 * @author JEDI-GroupD
 * @params this class does not have any parameters.
 * @throws this class does not throw any exceptions.
 */
public class City {
    // Unique identifier for the city.
    private String cityID;

    // Name of the city.
    private String cityName;

    /**
     * Constructs a City object with the specified city ID and name.
     *
     * @param cityID   the unique identifier for the city.
     * @param cityName the name of the city.
     */
    public City(String cityID, String cityName) {
        this.cityID = cityID;
        this.cityName = cityName;
    }

    /**
     * Gets the unique identifier for the city.
     *
     * @return the cityID of the city.
     */
    public String getCityID() {
        return cityID;
    }

    /**
     * Sets the unique identifier for the city.
     *
     * @param cityID the unique identifier to set for the city.
     */
    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    /**
     * Gets the name of the city.
     *
     * @return the cityName of the city.
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets the name of the city.
     *
     * @param cityName the name to set for the city.
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
