package com.flipkart.dao;

import com.flipkart.bean.FlipFitGyms;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlipFitGymDAOImplement implements FlipFitGymDAO {
    public List<FlipFitGyms> findGymsByCity(String city) {
        List<FlipFitGyms> gyms = new ArrayList<>();

        // Database connection code (replace with your actual connection method)
        try (Connection connection = Database.getConnection()) { // Assuming Database is a utility class
            String query = "SELECT * FROM gyms WHERE city = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, city);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                FlipFitGyms gym = new FlipFitGyms();
                gym.setName(resultSet.getString("name"));
                gym.setAddress(resultSet.getString("address"));
                gym.setCity(resultSet.getString("city"));
                gyms.add(gym);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions properly in real applications
        }

        return gyms; // Return the list of gyms found
    }

    @Override
    public List<FlipFitGyms> findGymByCity(String city) {
        return List.of();
    }
}
