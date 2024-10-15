package com.flipkart.dao;

import com.flipkart.bean.City;
import com.flipkart.bean.FlipFitGyms;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.utils.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class CityDAOImplement implements CityDAO{
    @Override
    public boolean cityExists(String cityName) {
        String sql = "SELECT 1 FROM city WHERE cityName = ?";
        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cityName);
            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        String sql = "SELECT * FROM city";

        try (Connection conn = dbutils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                City city = new City(rs.getString("cityID"), rs.getString("cityName"));
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbutils.closeConnection();
        }

        return cities;
    }

    // Method to add a city
    @Override
    public boolean addCity(City city) {
        String sql = "INSERT INTO city (cityID, cityName) VALUES (?, ?)";
        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            String cityID = "C" + System.currentTimeMillis(); // Generate a unique city ID
            statement.setString(1, city.getCityID());
            statement.setString(2, city.getCityName());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<FlipFitSlot> fetchSlotsByGymID(String gym_id) {
        List<FlipFitSlot> slots = new ArrayList<>();
        String sql = "SELECT * FROM slot WHERE gym_id = ?";

        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, gym_id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String slotID = resultSet.getString("slotID");
                    LocalDateTime startTime = resultSet.getTimestamp("startTime").toLocalDateTime();
                    LocalDateTime endTime = resultSet.getTimestamp("endTime").toLocalDateTime();
                    int capacity = resultSet.getInt("capacity");

                    FlipFitSlot slot = new FlipFitSlot(slotID, gym_id, startTime,endTime,capacity);
                    slots.add(slot);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return slots;
    }

    @Override
    public List<FlipFitGyms> getGymCenters(String city){
        List<FlipFitGyms> gymCenters = new ArrayList<>();
        String sql = "SELECT * FROM FlipFitGyms WHERE city = ?";

        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, city);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String gymID = resultSet.getString("gym_id");
                    String gymName = resultSet.getString("gym_name");
                    int availability = resultSet.getInt("no_of_slots");
                    Boolean status = resultSet.getBoolean("gym_status");
                    String pincode= resultSet.getString("pincode");
//                    String city = resultSet.getString("city");
                    String gymOwnerId = resultSet.getString("owner_id");

                    List<FlipFitSlot> slots = fetchSlotsByGymID(gymID);

                    // Assuming GymCenter has a constructor matching these parameters
                    if(status) {
                        FlipFitGyms gymCenter = new FlipFitGyms(gymID, gymName, availability, status, gymOwnerId, city, pincode, slots);
                        gymCenters.add(gymCenter);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gymCenters;
    }
}