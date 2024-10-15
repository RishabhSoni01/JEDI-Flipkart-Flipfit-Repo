package com.flipkart.dao;

import com.flipkart.bean.*;

import java.util.List;

/**
 * Interface for interacting with city-related data in the database.
 * Provides methods to manage and retrieve information about cities and associated gyms.
 *
 * @author Komal
 */
public interface CityDAO {

    /**
     * Checks whether a specific city exists in the database.
     *
     * @param cityName the name of the city to check.
     * @return true if the city exists, false otherwise.
     * @author JEDI GroupD
     */
    public boolean cityExists(String cityName);

    /**
     * Retrieves a list of all cities present in the database.
     *
     * @return a list of City objects representing all cities.
     * @author JEDI GroupD
     */
    public List<City> getAllCities();

    /**
     * Adds a new city to the database.
     *
     * @param city the City object containing details of the city to be added.
     * @return true if the city was successfully added, false otherwise.
     * @author JEDI GroupD
     */
    public boolean addCity(City city);

    /**
     * Retrieves a list of gym centers located in a specific city.
     *
     * @param city the name of the city for which to fetch gym centers.
     * @return a list of FlipFitGyms objects associated with the specified city.
     * @author JEDI GroupD
     */
    public List<FlipFitGyms> getGymCenters(String city);

    /**
     * Fetches all available slots for a specific gym identified by its ID.
     *
     * @param gymID the ID of the gym for which to retrieve available slots.
     * @return a list of FlipFitSlot objects representing the available slots.
     * @author JEDI GroupD
     */
    public List<FlipFitSlot> fetchSlotsByGymID(String gymID);
}
