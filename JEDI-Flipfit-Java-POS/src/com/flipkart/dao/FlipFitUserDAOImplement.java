package com.flipkart.dao;
import com.flipkart.bean.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.exception.InvalidLogin;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.dbutils;
import com.flipkart.exception.RegistrationFailedException;
public class FlipFitUserDAOImplement implements FlipFitUserDAO {
    public static void main(String[] args) {
        // Create a new instance of FlipFitUser
        FlipFitUser user1 = new FlipFitUser("cust123", "John Doe", "john.doe@example.com", "9876543210",
                "password123", "CityTest", "54321", 1, "johndoe");

        // Instantiate the DAO implementation
        FlipFitUserDAOImplement userDAO = new FlipFitUserDAOImplement();

        // Add the user
        boolean userAdded = userDAO.addUser(user1);
        System.out.println("User added: " + userAdded);

        // Create a new instance of FlipFitCustomer
        List<Booking> bookings = new ArrayList<>(); // Assuming you have a Booking class
        FlipFitCustomer customer = new FlipFitCustomer("cust123", "John Doe", "john.doe@example.com", "9876543210",
                "password123", "CityTest", "54321", 1, "johndoe", bookings);

        // Add the customer
        boolean customerRegistered = userDAO.registerCustomer(customer);
        System.out.println("Customer registered: " + customerRegistered);
    }




    public boolean addRole(FlipFitRole role) {
        String sql = "INSERT INTO role (id, role_name) VALUES (?, ?)";
        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, role.getRoleID());
            statement.setString(2, role.getRoleType());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean updateUser(FlipFitUser user){
        String sql = "UPDATE FlipFitUser SET username = ?, password = ? WHERE userid = ?";

        try (Connection conn = dbutils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getUserID());

            return ps.executeUpdate() > 0;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            dbutils.closeConnection();
        }
        return false;
    }
//    @Override
//    public FlipFitUser validateUser(String username, String password) {
//        String sql = "SELECT * FROM FlipFitUser WHERE username = ? AND password = ?";
//
//        try (Connection connection = dbutils.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setString(1, username);
//            statement.setString(2, password);
//            ResultSet rs = statement.executeQuery();
//            if (rs.next()) {
//                if (rs.getString("username").equals(username) && rs.getString("password").equals(password)) {
//                    FlipFitUser user = new FlipFitUser(
//                            rs.getString("userid"),        // userID
//                            rs.getString("name"),          // name
//                            rs.getString("email"),         // email
//                            rs.getString("phoneNumber"),   // phoneNumber
//                            rs.getString("password"),      // password
//                            rs.getString("city"),          // city
//                            rs.getString("pincode"),       // pincode
//                            rs.getInt("roleId"),           // roleID
//                            rs.getString("username")       // username
//                    );
//
//                    return user;
//                }
//                else {
//                    throw new InvalidLogin("Invalid login. Recheck you username and password");
//                }
//            }
//            else {
//                throw new UserNotFoundException(username);
//            }
//        }
//        catch (SQLException | UserNotFoundException e) {
//            e.getMessage();
//        } catch (InvalidLogin e) {
//            e.getMessage();
//        }
//        return null;
//    }
@Override
public FlipFitUser validateUser(String username, String password) throws InvalidLogin, UserNotFoundException {
    String sql = "SELECT * FROM FlipFitUser WHERE username = ?";

    try (Connection connection = dbutils.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, username);
        ResultSet rs = statement.executeQuery();

        // Check if the user exists
        if (rs.next()) {
            // If the user exists, check the password
            String storedPassword = rs.getString("password");
            if (!storedPassword.equals(password)) {
                // Password is incorrect
                throw new InvalidLogin("Invalid login. Recheck your username and password.");
            }

            // If both username and password are correct, create and return the user
            FlipFitUser user = new FlipFitUser(
                    rs.getString("userid"),        // userID
                    rs.getString("name"),          // name
                    rs.getString("email"),         // email
                    rs.getString("phoneNumber"),   // phoneNumber
                    storedPassword,                // password
                    rs.getString("city"),          // city
                    rs.getString("pincode"),       // pincode
                    rs.getInt("roleId"),           // roleID
                    rs.getString("username")       // username
            );

            return user;
        } else {
            // Username does not exist
            throw new UserNotFoundException(username);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Database error occurred during user validation.");
    }
}

    public boolean addUser(FlipFitUser user) {
        String sql = "INSERT INTO FlipFitUser (userid, name, email, phoneNumber, password, city, pincode, roleId, username) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set parameters in the specified order
            statement.setString(1, user.getUserID());        // userID
            statement.setString(2, user.getName());          // name
            statement.setString(3, user.getEmail());         // email
            statement.setString(4, user.getPhoneNumber());   // phoneNumber
            statement.setString(5, user.getPassword());      // password
            statement.setString(6, user.getCity());          // city
            statement.setString(7, user.getPincode());       // pincode
            statement.setInt(8, user.getRole());           // roleID
            statement.setString(9, user.getUsername());      // username
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0; // Return true if at least one row was inserted
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Handle exceptions appropriately
        }
        return false; // Return false if insertion failed or an exception occurred
    }
    @Override
    public boolean registerGymOwner(FlipFitGymOwner gymOwner) throws RegistrationFailedException {
        String sql = "INSERT INTO FlipFitGymOwner (username, userid, name, email, phoneNumber, pan, aadhar, gst_no, approval, city, pincode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set parameters in the specified order
            statement.setString(1, gymOwner.getUsername());  // username
            statement.setString(2, gymOwner.getUserID());    // userID
            statement.setString(3, gymOwner.getName());      // name
            statement.setString(4, gymOwner.getEmail());     // email
            statement.setString(5, gymOwner.getPhoneNumber()); // phoneNumber
            statement.setString(6, gymOwner.getPanCard());    // panCard
            statement.setString(7, gymOwner.getAadhar());     // aadhar
            statement.setString(8, gymOwner.getGST());        // GST
            statement.setInt(9, 0); // approval
            statement.setString(10, gymOwner.getCity());
            statement.setString(11, gymOwner.getPincode());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return true; // Return true if at least one row was inserted
            } else {
                throw new RegistrationFailedException("Registration failed: No rows inserted.");
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            throw new RegistrationFailedException("Registration failed due to a database error: ");
        }
    }

    @Override
    public boolean registerCustomer(FlipFitCustomer customer) throws RegistrationFailedException {
        String sql = "INSERT INTO FlipFitCustomer (username, userid, name, email, phoneNumber, city, pincode, approval) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, customer.getUsername());
            statement.setString(2, customer.getUserID());
            statement.setString(3, customer.getName());
            statement.setString(4, customer.getEmail());
            statement.setString(5, customer.getPhoneNumber());
            statement.setString(6, customer.getCity());
            statement.setString(7, customer.getPincode());
            statement.setInt(8, 0); // approval

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return true; // Return true if at least one row was inserted
            } else {
                throw new RegistrationFailedException("Registration failed: No rows inserted.");
            }

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            throw new RegistrationFailedException("Registration failed due to a database error: " );
        }
    }



}
