package com.flipkart.dao;

import com.flipkart.bean.*;
import com.flipkart.utils.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class FlipFitGymOwnerDAOImplement implements FlipFitGymOwnerDAO {
    public boolean addGymCenter(FlipFitGyms gymCenter) {
        String sql = "INSERT INTO FlipFitGyms (gym_id,gym_name,no_of_slots,gym_status,owner_id,city,pincode) VALUES (?,?,?,?,?,?,?)";

        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, gymCenter.getGymId());
            statement.setString(2, gymCenter.getGymName());
            statement.setInt(3, gymCenter.getNumberOfSlots());
            statement.setBoolean(4,false);
            statement.setString(5, gymCenter.getOwner());
            statement.setString(6, gymCenter.getCity());
            statement.setString(7, gymCenter.getPincode());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbutils.closeConnection();
        }
        return false;
    }
    public List<FlipFitGyms> getGymCenters(String userid) {
        List<FlipFitGyms> gymCenters = new ArrayList<>();
        String sql = "SELECT * FROM FlipFitGyms WHERE owner_id = ?";

        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, userid); // Assuming user.getId() gives the gymOwnerID

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String gymID = resultSet.getString("gym_id");
                String gymName = resultSet.getString("gym_name");
                int availableSlots = resultSet.getInt("no_of_slots");
                Boolean status = resultSet.getBoolean("gym_status");
                String owner = resultSet.getString("owner_id");

                String city = resultSet.getString("city");
                String pincode = resultSet.getString("pincode");
                if(status) {
                    List<FlipFitSlot> slots = new ArrayList<>();
                    FlipFitGyms gymCenter = new FlipFitGyms(gymID,gymName,availableSlots,status,owner,city,pincode,slots);
                    gymCenters.add(gymCenter);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbutils.closeConnection();
        }
        return gymCenters;
    }
    public void addSlots(String gymID, FlipFitSlot slot) {
        // Check if the same slot is already present in the slot table for the given gymCenter
        if (isSlotExists(gymID, slot)) {
            System.out.println("Slot already exists for the given GymCenter.");
            return; // Or throw an exception or handle the situation as per your requirement
        }

        String sql = "INSERT INTO slot (slotID, starttime, endtime, capacity, gym_id) VALUES (?,?,?,?,?)";

        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, slot.getSlotId()); // Assuming slot.getSlotID() retrieves the slot ID
            statement.setTimestamp(2, java.sql.Timestamp.valueOf(slot.getStartTime())); // Assuming slot.getStarttime() returns LocalDateTime
            statement.setTimestamp(3, java.sql.Timestamp.valueOf(slot.getEndTime())); // Assuming slot.getEndTime() returns a LocalTime object
            statement.setInt(4, slot.getSeatsAvailable()); // Assuming slot.getCapacity() returns the capacity
            statement.setString(5, gymID); // Assuming gymCenter.getGymID() retrieves the gymID

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Slot added successfully.");
            } else {
                System.out.println("Failed to add slot.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isSlotExists(String gymID, FlipFitSlot slot) {
        String sql = "SELECT COUNT(*) AS count FROM slot WHERE gym_id = ? AND starttime = ? AND endtime = ?";
        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, gymID);
            statement.setTimestamp(2, java.sql.Timestamp.valueOf(slot.getStartTime())); // Assuming slot.getStarttime() returns LocalDateTime
            statement.setTimestamp(3, java.sql.Timestamp.valueOf(slot.getEndTime()));

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void removeSlot(String gymID, LocalDateTime starttime) {
        String sql = "DELETE FROM slot WHERE gym_id = ? AND starttime = ?";

        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Convert LocalDateTime to java.sql.Timestamp for DATETIME columns
            statement.setString(1, gymID);
            statement.setTimestamp(2, java.sql.Timestamp.valueOf(starttime));

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Slot deleted successfully.");
            } else {
                System.out.println("Slot not found or failed to delete.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public FlipFitGymOwner getGymOwner(FlipFitUser user) {
        FlipFitGymOwner gymOwner = null;
        String sql = "SELECT g.userid, g.username, g.aadhar, g.gst_no, g.pan, u.name, u.email, u.phoneNumber " +
                "FROM FlipFitGymOwner g " +
                "JOIN FlipFitUser u ON g.userid = u.userid " +
                "WHERE u.username = ?";

        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getUsername());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String userid = resultSet.getString("userid");
                    String username = resultSet.getString("username");
                    String aadhar = resultSet.getString("aadhar");
                    String gstNo = resultSet.getString("gst_no");
                    String pan = resultSet.getString("pan");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String contactNo = resultSet.getString("phoneNumber");

                    gymOwner = new FlipFitGymOwner(userid,name,email,contactNo,user.getPassword(),user.getCity(),user.getPincode(),user.getRole(),username,pan,aadhar,gstNo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gymOwner;
    }
    public boolean updateProfile(FlipFitGymOwner gymOwner){
        String sql = "UPDATE FlipFitGymOwner SET username = ?, name = ?, email = ?, phoneNumber = ?, city = ?, pincode=?, aadhar=?,pan=?,gst_no=? WHERE userid = ?";

        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, gymOwner.getUsername());
            statement.setString(2, gymOwner.getName());
            statement.setString(3, gymOwner.getEmail());
            statement.setString(4, gymOwner.getPhoneNumber());
            statement.setString(5,gymOwner.getCity());
            statement.setString(6,gymOwner.getPincode());
            statement.setString(7, gymOwner.getAadhar());
            statement.setString(8,gymOwner.getPanCard());
            statement.setString(9,gymOwner.getGST());
            statement.setString(10,gymOwner.getUserID());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
