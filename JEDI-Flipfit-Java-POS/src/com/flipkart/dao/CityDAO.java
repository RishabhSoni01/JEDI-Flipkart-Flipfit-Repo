package com.flipkart.dao;


import com.flipkart.bean.*;

import java.util.List;

public interface CityDAO {
    public boolean cityExists(String cityName);
    public List<City> getAllCities();
    public boolean addCity(City city);
    public List<FlipFitGyms> getGymCenters(String city);
    public List<FlipFitSlot> fetchSlotsByGymID(String gymID);
}