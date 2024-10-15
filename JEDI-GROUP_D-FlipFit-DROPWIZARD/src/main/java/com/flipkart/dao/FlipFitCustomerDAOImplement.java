package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.bean.FlipFitUser;
import com.flipkart.utils.dbutils;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlipFitCustomerDAOImplement implements FlipFitCustomerDAO {

    // Retrieves a list of bookings for a specified user.
    // Executes a SQL query to fetch booking details from the database.
    public List<Booking> viewBookings(String userId) {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT b.bookingID, b.gymID, b.slotID, b.date, gc.gym_name, s.starttime, s.endtime, s.capacity " +
                "FROM booking b " +
                "JOIN FlipFitGyms gc ON b.gymID = gc.gym_id " +
                "JOIN slot s ON b.slotID = s.slotID " +
                "WHERE b.userID = ?";

        try (Connection conn = dbutils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String bookingId = rs.getString("bookingID");
                String gymId = rs.getString("gymID");
                String slotId = rs.getString("slotID");
                String gymName = rs.getString("gym_name");

                Timestamp startTimeTs = rs.getTimestamp("starttime");
                Timestamp endTimeTs = rs.getTimestamp("endtime");
                LocalDateTime startTime = startTimeTs.toLocalDateTime();
                LocalDateTime endTime = endTimeTs.toLocalDateTime();

                int capacity = rs.getInt("capacity");
                Timestamp dateTs = rs.getTimestamp("date");
                LocalDateTime date = dateTs.toLocalDateTime();

                FlipFitSlot slot = new FlipFitSlot(slotId, gymId, startTime, endTime, capacity);
                Booking booking = new Booking(userId, bookingId, gymId, slotId, gymName, slot, date);
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbutils.closeConnection();
        }

        return bookings;
    }

    // Removes a specific booking for a user from the database.
    // Decreases the slot capacity after successfully deleting the booking.
    public boolean removeBooking(String userID, String slotID) {
        String deleteBookingSql = "DELETE FROM booking WHERE userID = ? AND slotID = ?";

        try (Connection conn = dbutils.getConnection();
             PreparedStatement deleteBookingStmt = conn.prepareStatement(deleteBookingSql)) {

            // Delete the booking
            deleteBookingStmt.setString(1, userID);
            deleteBookingStmt.setString(2, slotID);
            int rowsDeleted = deleteBookingStmt.executeUpdate();

            if (rowsDeleted > 0) {
                updateCapacity(slotID, 1);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Adds a new booking to the database for a user.
    // Records the current date and time as the booking date.
    public boolean addBooking(Booking booking) {
        String sql = "INSERT INTO booking (userID, bookingID, gymID, slotID, date) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = dbutils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Set the parameters
            ps.setString(1, booking.getUserID());
            ps.setString(2, booking.getBookingID());
            ps.setString(3, booking.getGymID());
            ps.setString(4, booking.getSlotID());

            // Set the current date and time for the booking
            ps.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));

            // Execute the insert operation
            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbutils.closeConnection();
        }
        return false;
    }

    // Updates the profile details of a FlipFitCustomer.
    // Executes a SQL update statement based on the provided customer information.
    public boolean updateProfile(FlipFitCustomer customer) {
        String sql = "UPDATE FlipFitCustomer SET username = ?, name = ?, email = ?, phoneNumber = ?, city = ?, pincode=? WHERE userid = ?";

        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, customer.getUsername());
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhoneNumber());
            statement.setString(5, customer.getCity());
            statement.setString(6, customer.getPincode());
            statement.setString(7, customer.getUserID());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Retrieves a FlipFitCustomer object based on the provided username.
    // Executes a SQL query to fetch customer details from the database.
    public FlipFitCustomer getCustomer(FlipFitUser user) {
        FlipFitCustomer customer = null;
        String sql = "SELECT * FROM FlipFitCustomer WHERE username = ?";
        List<Booking> bookings = null;
        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getUsername());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String userid = resultSet.getString("userid");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String contactNo = resultSet.getString("phoneNumber");
                    customer = new FlipFitCustomer(userid, name, email, contactNo, user.getPassword(), user.getCity(), user.getPincode(), user.getRole(), username, bookings);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }


//    public FlipFitCustomer getCustomer(String username) {
//        FlipFitCustomer customer = null;
//        String sql = "SELECT * FROM FlipFitCustomer WHERE username = ?";
//        List<Booking> bookings = null;
//        try (Connection connection = dbutils.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setString(1, username);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                if (resultSet.next()) {
//                    String userid = resultSet.getString("userid");
//                    String name = resultSet.getString("name");
//                    String email = resultSet.getString("email");
//                    String contactNo = resultSet.getString("phoneNumber");
//                    String city = resultSet.getString("city");
//                    customer = new FlipFitCustomer(userid, name, email, contactNo, user.getPassword(), city, user.getPincode(), user.getRole(), username, bookings);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return customer;
//    }

    // Checks if a booking already exists for a specific user and slot.
    // Executes a SQL query to count existing bookings for the given criteria.
    public boolean bookingExists(Booking booking) {
        String sql = "SELECT COUNT(*) FROM booking WHERE slotID = ? AND userID = ?";

        try (Connection conn = dbutils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Set the parameters
            ps.setString(1, booking.getSlotID());
            ps.setString(2, booking.getUserID());

            // Execute the query
            ResultSet rs = ps.executeQuery();

            // Check if a record exists
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbutils.closeConnection();
        }
        return false;
    }

    // Updates the capacity of a specified slot in the database.
    // Increments or decrements the capacity based on the provided delta value.
    public boolean updateCapacity(String slotID, int delta) {
        String sql = "UPDATE slot SET capacity = capacity + ? WHERE slotID = ?";

        try (Connection conn = dbutils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Set the parameters
            ps.setInt(1, delta);
            ps.setString(2, slotID);

            // Execute the update
            int rowsAffected = ps.executeUpdate();

            // Return true if one or more rows were updated
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbutils.closeConnection();
        }
        return false;
    }

    @Override
    public FlipFitCustomer getCustomerById(String userId) {
        List<Booking> bookings = null;
        FlipFitCustomer customer = null;
        String sql = "SELECT * FROM FlipFitUser WHERE userid = ?";
        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, userId);
            System.out.println("Looking for userId: '" + userId + "'");
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String phoneNumber = resultSet.getString("phoneNumber");
                    String password = resultSet.getString("password");
                    String city = resultSet.getString("city");
                    String pincode = resultSet.getString("pincode");
                    // Initialize or retrieve bookings if necessary

                    customer = new FlipFitCustomer(userId, name,phoneNumber, email, password, city, pincode, 3, username, bookings);
                    System.out.println("juybukykyykbfyff");
                    System.out.println(customer);
                }
                else {
                    System.out.println("No customer found with userId: " + userId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        System.out.println("customer35435gefd");
//        System.out.println(customer);
        return customer;
    }
}
