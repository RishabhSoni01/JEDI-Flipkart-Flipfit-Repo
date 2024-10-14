package com.flipkart.business;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitUser;
import com.flipkart.dao.FlipFitUserDAO;
import com.flipkart.dao.FlipFitUserDAOImplement;
import com.flipkart.exception.InvalidLogin;
import com.flipkart.exception.UserNotFoundException;

import java.util.HashMap;

public class FlipFitUserService implements FlipFitUserInterface{
    // HashMap to store users by their username
    static HashMap<String, FlipFitUser> UsersMap = new HashMap<>();

    // DAO implementations for user-related database operations
    private FlipFitUserDAOImplement flipFitUserDAOImplement = new FlipFitUserDAOImplement();
    private FlipFitUserDAO userDAO = new FlipFitUserDAOImplement();

    /**
     * Adds a user to the in-memory UsersMap.
     *
     * @param user The FlipFitUser object to be added.
     */
    public void addUser(FlipFitUser user) {
        UsersMap.put(user.getUsername(), user);
    }

    /**
     * Authenticates a user with the given username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return The authenticated FlipFitUser object, or null if authentication fails.
//     */
//    public FlipFitUser login(String username, String password) throws InvalidLogin{
//        return flipFitUserDAOImplement.validateUser(username, password);
//    }
    public FlipFitUser login(String username, String password) {
        try {
            return flipFitUserDAOImplement.validateUser(username, password);
        } catch (InvalidLogin e) {
            System.out.println("Login failed: " + e.getMessage());
            return null; // Return null or handle it based on your application's needs
        } catch (UserNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return null; // Similarly, handle it as needed
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            return null; // Handle other exceptions if needed
        }
    }


    /**
     * Validates the user's old password.
     *
     * @param user        The FlipFitUser object whose password is to be validated.
     * @param oldPassword The old password to compare against.
     * @return True if the old password matches, false otherwise.
     */
    public boolean validatePassword(FlipFitUser user, String oldPassword) {
        return user.getPassword().equals(oldPassword);
    }

    /**
     * Confirms and updates the user's password if the new passwords match.
     *
     * @param user             The FlipFitUser object whose password is to be updated.
     * @param newPassword      The new password to set.
     * @param confirmPassword   The confirmation of the new password.
     */
    public void confirmPassword(FlipFitUser user, String newPassword, String confirmPassword) {
        if (newPassword.equals(confirmPassword)) {
            user.setPassword(newPassword);
            if (userDAO.updateUser(user)) {
                System.out.println("Password Changed Successfully");
            }
        } else {
            System.out.println("Password did not match");
        }
    }

    /**
     * Registers a gym owner in the system.
     *
     * @param gymOwner The FlipFitGymOwner object to be registered.
     * @return True if registration is successful, false otherwise.
     */

    public boolean registerGymOwner(FlipFitGymOwner gymOwner) {
        return userDAO.registerGymOwner(gymOwner);
    }

    /**
     * Registers a customer in the system.
     *
     * @param customer The FlipFitCustomer object to be registered.
     * @return True if registration is successful, false otherwise.
     */

    public boolean registerCustomer(FlipFitCustomer customer) {
        return userDAO.registerCustomer(customer);
    }
}
