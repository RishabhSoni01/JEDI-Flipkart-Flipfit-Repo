package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.business.BookingService;
import com.flipkart.bean.Booking;
import com.flipkart.utils.dbutils;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class FlipFitCustomerDAOImplement implements FlipFitCustomerDAO {
    @Override
    public List<Booking> viewBookings(String userId) {
        return List.of();
    }

    @Override
    public boolean addBooking(String userId,String bookingId, String gymId, String slotId) {
        String sql = "INSERT INTO booking (userID, bookingID, gymID, slotID, date) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = dbutils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Set the parameters
            ps.setString(1, userId);
            ps.setString(2, bookingId);
            ps.setString(3, gymId);
            ps.setString(4, slotId);

            // Set the current date and time for the booking
            ps.setTimestamp(5, java.sql.Timestamp.valueOf(LocalDateTime.now()));

            // Execute the insert operation
            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            dbutils.closeConnection();
        }
        return false;
    }
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
    public boolean removeBooking(String userId, String gymId, String slotId, LocalDate bookingDate) {
        String deleteBookingSql = "DELETE FROM booking WHERE userID = ? AND slotID = ?";

        try (Connection conn = dbutils.getConnection();
             PreparedStatement deleteBookingStmt = conn.prepareStatement(deleteBookingSql)) {

            // Delete the booking
            deleteBookingStmt.setString(1, userId);
            deleteBookingStmt.setString(2, slotId);
            int rowsDeleted = deleteBookingStmt.executeUpdate();

            if (rowsDeleted > 0) {
                // Update the slot capacity
                updateCapacity(slotId, 1);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FlipFitCustomer viewProfile(String userId) {
        FlipFitCustomer customer = null;

        String query = "SELECT u.name, u.email, u.phoneNumber, u.city, u.pincode FROM FlipFitUser u ";

        try (Connection connection = dbutils.getConnection(); // Assuming Database is a utility class
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Create a new FlipFitCustomer object
                customer = new FlipFitCustomer(
                        userId,
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("phoneNumber"),
                        "", // Assuming password is not retrieved for security reasons
                        resultSet.getString("city"),
                        resultSet.getString("pincode"),
                        1, // Role can be set to 0 or an appropriate value if needed
                        resultSet.getString("userId") // Username can be set to empty or fetched if available
                );

                // Now retrieve bookings for the customer
                customer.setBookings(viewBookings(userId)); // Fetch bookings
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions properly in real applications
        }

        return customer;
    }

    @Override
    public boolean registerCustomer(String username, String password, String email, String city, String phoneNumber, String pincode, String role) {
        return false;
    }

    @Override
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        return false;
    }

    @Override
    public boolean login(String username, String password) {
        return false;
    }
}



