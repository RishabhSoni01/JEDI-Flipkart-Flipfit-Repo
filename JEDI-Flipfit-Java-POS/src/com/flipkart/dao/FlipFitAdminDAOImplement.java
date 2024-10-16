package com.flipkart.dao;
import com.flipkart.bean.*;
import com.flipkart.utils.dbutils;
import com.sun.jdi.connect.spi.Connection;
import com.flipkart.exception.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.flipkart.utils.dbutils;
public class FlipFitAdminDAOImplement implements FlipFitAdminDAO {
    Connection connection;
    public boolean approveGymOwner(String userID) throws GymOwnerNotFoundException {
        String checkSql = "SELECT COUNT(*) FROM FlipFitGymOwner WHERE userid = ?";
        String updateSql = "UPDATE FlipFitGymOwner SET approval = ? WHERE userid = ?";

        try (java.sql.Connection connection = dbutils.getConnection();
             PreparedStatement checkStatement = connection.prepareStatement(checkSql);
             PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {

            // Check if the gym owner exists
            checkStatement.setString(1, userID);
            ResultSet rs = checkStatement.executeQuery();
            if (rs.next() && rs.getInt(1) == 0) {
                throw new GymOwnerNotFoundException("Gym owner with ID " + userID + " not found.");
            }

            // Proceed to approve if the gym owner exists
            updateStatement.setInt(1, 1);
            updateStatement.setString(2, userID);
            int rowsAffected = updateStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error occurred while approving gym owner."); // Handle SQL exceptions
        } finally {
            dbutils.closeConnection();
        }
    }


    public boolean approveCustomer(String userID) throws CustomerNotFoundException {
        String checkSql = "SELECT COUNT(*) FROM FlipFitCustomer WHERE userid = ?";
        String updateSql = "UPDATE FlipFitCustomer SET approval = ? WHERE userid = ?";

        try (java.sql.Connection connection = dbutils.getConnection();
             PreparedStatement checkStatement = connection.prepareStatement(checkSql);
             PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {

            // Check if the customer exists
            checkStatement.setString(1, userID);
            ResultSet rs = checkStatement.executeQuery();
            if (rs.next() && rs.getInt(1) == 0) {
                throw new CustomerNotFoundException("Customer with ID " + userID + " not found.");
            }

            // Proceed to approve if the customer exists
            updateStatement.setInt(1, 1);
            updateStatement.setString(2, userID);
            int rowsAffected = updateStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error occurred while approving customer."); // Handle SQL exceptions
        } finally {
            dbutils.closeConnection();
        }
    }



    public List<FlipFitGymOwner> getPendingGymOwners() {
        List<FlipFitGymOwner> pendingGymOwners = new ArrayList<>();
        String sql = "SELECT * FROM FlipFitGymOwner WHERE approval = ?"; // Ensure correct table name

        try (java.sql.Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, 0); // Check for pending approvals
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                String userID = resultSet.getString("userid");
                String username = resultSet.getString("username");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phoneNumber"); // Correct column name
                String panCard = resultSet.getString("pan"); // Assuming "pan" is the correct column name
                String aadhar = resultSet.getString("aadhar");
                String gst = resultSet.getString("gst_no"); // Assuming "gst_no" is the correct column name
                int isApproved = resultSet.getInt("approval"); // Assuming "approval" is the correct column name
                String city = resultSet.getString("city");
                String pincode = resultSet.getString("pincode");

                // Constructing FlipFitGymOwner with all parameters
                FlipFitGymOwner gymOwner = new FlipFitGymOwner(userID, name, email, phoneNumber, "password", city, pincode, 2, username,panCard,aadhar,gst);
                gymOwner.setPanCard(panCard);
                gymOwner.setAadhar(aadhar);
                gymOwner.setGST(gst);
                gymOwner.setApproved(isApproved); // Set approval status

                pendingGymOwners.add(gymOwner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbutils.closeConnection();
        }

        return pendingGymOwners;
    }
    public List<FlipFitGyms> getPendingGymCenters() {
        List<FlipFitGyms> pendingGymCenters = new ArrayList<>();
        String sql = "SELECT * FROM FlipFitGyms WHERE gym_status = ?";

        try (java.sql.Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, 0); // Assuming we're looking for unapproved gyms

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String gymId = resultSet.getString("gym_id");
                String gymName = resultSet.getString("gym_name");
                String pincode = resultSet.getString("pincode");
                String city = resultSet.getString("city");
                int numberOfSlots = resultSet.getInt("no_of_slots");
                boolean gymStatus = resultSet.getBoolean("gym_status"); // Assuming this column indicates the gym's active status
                String owner=resultSet.getString("owner_id");
                // Retrieve the gym owner object using gymOwnerID// Assuming you have a method to retrieve the gym owner

                // Create the FlipFitGyms object with the correct parameters
                List<FlipFitSlot> slots = new ArrayList<>();
                FlipFitGyms gymCenter = new FlipFitGyms(gymId, gymName, numberOfSlots, gymStatus, owner, city, pincode,slots);
                pendingGymCenters.add(gymCenter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbutils.closeConnection();
        }

        return pendingGymCenters;
    }

    public List<FlipFitGyms> getAllGymCenters() {
        List<FlipFitGyms> allGymCenters = new ArrayList<>();
        String sql = "SELECT * FROM FlipFitGyms"; // Update to the correct table name

        try (java.sql.Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String gymId = resultSet.getString("gym_id");
                String gymName = resultSet.getString("gym_name");
                int numberOfSlots = resultSet.getInt("no_of_slots");
                boolean gymStatus = resultSet.getBoolean("gym_status");
                String ownerId = resultSet.getString("owner_id");
                String city = resultSet.getString("city");
                String pincode = resultSet.getString("pincode");

                // Retrieve the gym owner object using ownerId

                // Create the FlipFitGyms object with the correct parameters
                List<FlipFitSlot> slots = new ArrayList<>();
                FlipFitGyms gymCenter = new FlipFitGyms(gymId, gymName, numberOfSlots, gymStatus, ownerId, city, pincode,slots);
                allGymCenters.add(gymCenter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbutils.closeConnection();
        }

        return allGymCenters;
    }
    public boolean approveGymCenter(String gymID) {
        String checkSql = "SELECT COUNT(*) FROM FlipFitGyms WHERE gym_id = ?";
        String updateSql = "UPDATE FlipFitGyms SET gym_status = ? WHERE gym_id = ?";

        try (java.sql.Connection conn = dbutils.getConnection();
             PreparedStatement checkPs = conn.prepareStatement(checkSql);
             PreparedStatement updatePs = conn.prepareStatement(updateSql)) {

            // Check if the gym exists
            checkPs.setString(1, gymID);
            ResultSet rs = checkPs.executeQuery();
            if (rs.next() && rs.getInt(1) == 0) {
                // Gym not found, return false
                System.out.println("Gym with ID " + gymID + " not found.");
                return false;
            }

            // Proceed to approve if the gym exists
            updatePs.setInt(1, 1);
            updatePs.setString(2, gymID);
            int rowsAffected = updatePs.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            // Optionally, handle the exception as needed
        } finally {
            dbutils.closeConnection();
        }
        return false;
    }


    public List<FlipFitGymOwner> getAllGymOwners() {
        List<FlipFitGymOwner> allGymOwners = new ArrayList<>();
        String sql = "SELECT * FROM FlipFitGymOwner"; // Adjusted to select all gym owners

        try (java.sql.Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                String userID = resultSet.getString("userid");
                String username = resultSet.getString("username");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phoneNumber"); // Correct column name
                String panCard = resultSet.getString("pan"); // Assuming "pan" is the correct column name
                String aadhar = resultSet.getString("aadhar");
                String gst = resultSet.getString("gst_no"); // Assuming "gst_no" is the correct column name
                int isApproved = resultSet.getInt("approval"); // Assuming "approval" is the correct column name
                String city = resultSet.getString("city");
                String pincode = resultSet.getString("pincode");

                // Constructing FlipFitGymOwner with all parameters
                FlipFitGymOwner gymOwner = new FlipFitGymOwner(userID, name, email, phoneNumber, "password", city, pincode, 2, username,panCard,aadhar,gst);
                gymOwner.setPanCard(panCard);
                gymOwner.setAadhar(aadhar);
                gymOwner.setGST(gst);
                gymOwner.setApproved(isApproved); // Set approval status

                allGymOwners.add(gymOwner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbutils.closeConnection();
        }

        return allGymOwners;
    }
    public List<FlipFitCustomer> getAllCustomers() {
        List<FlipFitCustomer> allCustomers = new ArrayList<>();
        String sql = "SELECT * FROM FlipFitCustomer"; // Adjusted to select all customers

        try (java.sql.Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String userID = resultSet.getString("userid");
                String username = resultSet.getString("username");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phoneNumber");
                String city = resultSet.getString("city");
                String pincode = resultSet.getString("pincode");
                int approvalStatus = resultSet.getInt("approval");

                // Constructing the FlipFitCustomer object
                List<Booking> bookings = null;
                FlipFitCustomer customer = new FlipFitCustomer(userID, name, email, phoneNumber, "password", city, pincode, 3, username,bookings);
                customer.setApproval(approvalStatus); // Set approval status

                allCustomers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbutils.closeConnection();
        }

        return allCustomers;
    }
    public List<FlipFitCustomer> getPendingCustomers() {
        List<FlipFitCustomer> pendingCustomers = new ArrayList<>();
        String sql = "SELECT * FROM FlipFitCustomer WHERE approval = ?"; // Select only pending customers

        try (java.sql.Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, 0); // Check for customers with approval status 0

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String userID = resultSet.getString("userid");
                String username = resultSet.getString("username");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phoneNumber");
                String city = resultSet.getString("city");
                String pincode = resultSet.getString("pincode");
                int approvalStatus = resultSet.getInt("approval");
                List<Booking> bookings = null;

                // Constructing the FlipFitCustomer object
                FlipFitCustomer customer = new FlipFitCustomer(userID, name, email, phoneNumber, "password", city, pincode, 3, username,bookings);
                customer.setApproval(approvalStatus); // Set approval status

                pendingCustomers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbutils.closeConnection();
        }

        return pendingCustomers;
    }

}
