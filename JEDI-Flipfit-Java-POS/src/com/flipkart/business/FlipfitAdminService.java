package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.dao.FlipFitUserDAOImplement;
import com.flipkart.dao.FlipFitAdminDAOImplement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlipfitAdminService implements FlipfitAdminServiceInterface {

    // DAO implementations for admin and user data access
    private FlipFitAdminDAOImplement adminDAO;
    private FlipFitUserDAOImplement userDAO;

    // Static maps to store gym centers and pending centers
    public static Map<String, FlipFitGyms> gymCenters = new HashMap<>();
    public static Map<String, FlipFitGyms> pendingCenters = new HashMap<>();

    // Constructor initializes DAOs and sets up the admin account
    public FlipfitAdminService() {
        this.adminDAO = new FlipFitAdminDAOImplement();
        this.userDAO = new FlipFitUserDAOImplement();
        initializeAdmin(); // Set up the admin user
    }

    /**
     * Initializes the admin user if it doesn't already exist.
     */
    private void initializeAdmin() {
        // Create a role object for Admin
        FlipFitRole role = new FlipFitRole(1, "ADMIN");

        // Create an admin user with the appropriate details
        FlipFitAdmin admin = new FlipFitAdmin(
                "bean",          // userID
                "BeanAdmin",     // name
                "bean@gmail.com",// email
                "1234567890",    // phoneNumber
                "Password",      // password
                "CityName",      // city
                "000000",        // pincode
                role.getRoleID(),// roleID
                "bean@1234"     // username
        );

        // Create a FlipFitUser object from the admin details
        FlipFitUser user = new FlipFitUser(
                admin.getUserID(),     // userID
                admin.getName(),       // name
                admin.getEmail(),      // email
                admin.getPhoneNumber(), // phoneNumber
                admin.getPassword(),    // password
                admin.getCity(),       // city
                admin.getPincode(),    // pincode
                admin.getRole(),       // roleID
                admin.getUsername()    // username
        );
        try {
            // Check if the user already exists and add the user if not
            FlipFitUser existingUser = userDAO.validateUser(user.getUsername(), user.getPassword());
            if (existingUser == null) {
                if (userDAO.addUser(user)) {
                    System.out.println("User added successfully");
                } else {
                    System.out.println("Failed to add user");
                }
            } else {
                System.out.println("User already exists");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Object approveGymOwner(String gymOwnerId) {
        // Approve a gym owner based on their ID
        boolean flag = adminDAO.approveGymOwner(gymOwnerId);
        if (flag) {
            return "Gym Owner approved successfully";
        } else {
            return "Gym Owner not approved";
        }

    }

    @Override
    public List<FlipFitGymOwner> viewPendingGymOwners() {
        // Retrieve and display a list of pending gym owners
        List<FlipFitGymOwner> pendingGO = adminDAO.getPendingGymOwners();
        System.out.println("Listing all pending gym owners");
        pendingGO.forEach(gymOwner ->
                System.out.println("Owner ID: " + gymOwner.getUserID() + " Owner Name: " + gymOwner.getName())
        );

        return pendingGO;
    }

    @Override
    public List<FlipFitGyms> viewPendingGyms() {
        // Retrieve and display a list of pending gyms
        List<FlipFitGyms> pendingGC = adminDAO.getPendingGymCenters();
        System.out.println("Listing all pending gyms");
        pendingGC.forEach(gymCenter ->
                System.out.println("Gym ID: " + gymCenter.getGymId() + " Gym Name: " + gymCenter.getGymName())
        );

        return pendingGC;
    }

    @Override
    public void approveGym(String gymId)  {
        // Approve a gym based on its ID
        boolean flag = adminDAO.approveGymCenter(gymId);
        if (flag) {
             System.out.println("Gym Approved successfully");
        } else {
            System.out.println("Gym not approved");
        }
    }

    @Override
    public List<FlipFitGyms> viewGyms() {
        // Retrieve and display all gyms
        List<FlipFitGyms> allGyms = adminDAO.getAllGymCenters(); // Assuming this method exists in your DAO
        System.out.println("Listing all gyms:");
        allGyms.forEach(gym ->
                System.out.println("Gym ID: " + gym.getGymId() +
                        " Gym Name: " + gym.getGymName() +
                        " Slots: " + gym.getNumberOfSlots() +
                        " Status: " + (gym.getGymStatus() ? "Active" : "Inactive") +
                        " City: " + gym.getCity() +
                        " Pincode: " + gym.getPincode())
        );

        return allGyms;
    }

    @Override
    public List<FlipFitGymOwner> viewGymsOwner() {
        // Retrieve and display all gym owners
        List<FlipFitGymOwner> allGymOwners = adminDAO.getAllGymOwners(); // Assuming this method exists in your DAO
        System.out.println("Listing all gym owners:");
        allGymOwners.forEach(gymOwner ->
                System.out.println("Owner ID: " + gymOwner.getUserID() +
                        " Owner Name: " + gymOwner.getName() +
                        " Email: " + gymOwner.getEmail() +
                        " Phone Number: " + gymOwner.getPhoneNumber() +
                        " City: " + gymOwner.getCity() +
                        " Pincode: " + gymOwner.getPincode())
        );

        return allGymOwners;
    }

    @Override
    public Boolean login(String username, String password) {
        // Logic to validate user login
        return false; // Replace with actual implementation
    }

    @Override
    public List<FlipFitCustomer> getAllCustomers() {
        // Retrieve and display all customers
        List<FlipFitCustomer> allCustomers = adminDAO.getAllCustomers();
        System.out.println("Listing all customers:");
        allCustomers.forEach(customer ->
                System.out.println("Owner ID: " + customer.getUserID() +
                        " Owner Name: " + customer.getName() +
                        " Email: " + customer.getEmail() +
                        " Phone Number: " + customer.getPhoneNumber() +
                        " City: " + customer.getCity() +
                        " Pincode: " + customer.getPincode())
        );

        return allCustomers;
    }

    @Override
    public List<FlipFitCustomer> getPendingCustomers() {
        // Retrieve and display pending customers
        List<FlipFitCustomer> pendingCustomers = adminDAO.getPendingCustomers();
        System.out.println("Listing all pending customers:");
        pendingCustomers.forEach(customer ->
                System.out.println("Owner ID: " + customer.getUserID() +
                        " Owner Name: " + customer.getName() +
                        " Email: " + customer.getEmail() +
                        " Phone Number: " + customer.getPhoneNumber() +
                        " City: " + customer.getCity() +
                        " Pincode: " + customer.getPincode())
        );

        return pendingCustomers; // Replace with actual implementation
    }

    @Override
    public Object approveCustomers(String customerId) {
        // Approve a customer based on their ID
        boolean flag = adminDAO.approveCustomer(customerId);
        if (flag) {
            return "Customer approved successfully";
        } else {
            return "Customer not approved";
        }
    }
}
