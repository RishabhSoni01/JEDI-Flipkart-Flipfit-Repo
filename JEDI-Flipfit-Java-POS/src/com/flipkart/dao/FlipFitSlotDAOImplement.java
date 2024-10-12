package com.flipkart.dao;

import com.flipkart.bean.FlipFitSlot;
import com.flipkart.utils.dbutils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlipFitSlotDAOImplement implements FlipFitSlotDAO {
    @Override
    public List<FlipFitSlot> findFreeSlotsByGymId(String gymId) {
        List<FlipFitSlot> slots = new ArrayList<>();

        // Database connection code (replace with your actual connection method)
        try (Connection connection = dbutils.getConnection()) { // Assuming Database is a utility class
            String query = "SELECT * FROM slots WHERE gym_id = ? AND is_free = true"; // Adjust as per your table structure
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, gymId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                FlipFitSlot slot = new FlipFitSlot();
                slot.setSlotId(resultSet.getString("slot_id"));
                slot.setGymId(resultSet.getString("gym_id"));
                slot.setStartTime(resultSet.getString("start_time"));
                slot.setEndTime(resultSet.getString("end_time"));
                slot.setFree(resultSet.getBoolean("is_free"));
                slots.add(slot);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions properly in real applications
        }

        return slots; // Return the list of free slots found

    }
}
