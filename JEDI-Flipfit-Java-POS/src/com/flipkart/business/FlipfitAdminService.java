package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.dao.FlipFitUserDAOImplement;
import com.flipkart.dao.FlipFitAdminDAOImplement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlipfitAdminService implements FlipfitAdminServiceInterface {

    private FlipFitAdminDAOImplement adminDAO;
    private FlipFitUserDAOImplement userDAO;

    public FlipfitAdminService() {
        this.adminDAO = new FlipFitAdminDAOImplement();
        this.userDAO = new FlipFitUserDAOImplement();
//        initializeAdmin();
    }
    public static Map<String, FlipFitGyms> gymCenters = new HashMap<>();
    public static Map<String, FlipFitGyms> pendingCenters = new HashMap<>();

    private void initializeAdmin() {
        // Create a role object for Admin
        FlipFitRole role = new FlipFitRole(1, "ADMIN");

        // Create an admin user with the correct parameters
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

        // Create a FlipFitUser object
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

        // Check if the user already exists and add the user
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

    @Override
    public Object approveGymOwner(String gymOwnerId) {
        boolean flag= adminDAO.approveGymOwner(gymOwnerId);
        if(flag){
            return "Gym Owner approved successfully";
        }
        else
            return ("Gym Owner not approved");
    }

    @Override
    public List<FlipFitGymOwner> viewPendingGymOwners() {
        List<FlipFitGymOwner> pendingGO = adminDAO.getPendingGymOwners();
        System.out.println("Listing all pending gym owners");
        for (FlipFitGymOwner gymOwner : pendingGO) {
            System.out.println("Owner ID: " + gymOwner.userID+" Owner Name: "+gymOwner.getName());
        }
        return pendingGO;
    }

    @Override
    public List<FlipFitGyms> viewPendingGyms() {
        List<FlipFitGyms> pendingGC = adminDAO.getPendingGymCenters();
        System.out.println("Listing all pending gyms");
        for (FlipFitGyms gymCenter : pendingGC) {
            System.out.println("Gym ID: " + gymCenter.getGymId()+" Gym Name: "+ gymCenter.getGymName());
        }

        return pendingGC;
    }

    @Override
    public Object approveGym(String gymId) {
       boolean flag=adminDAO.approveGymCenter(gymId);
       if(flag){
           return "Gym Approved successfully";
       }
       else {
           return ("Gym Approved not approved");
       }
    }

    @Override
    public List<FlipFitGyms> viewGyms() {
        List<FlipFitGyms> allGyms = adminDAO.getAllGymCenters(); // Assuming this method exists in your DAO
        System.out.println("Listing all gyms:");
        for (FlipFitGyms gym : allGyms) {
            System.out.println("Gym ID: " + gym.getGymId() + "Gym Name: " + gym.getGymName() +
                    " Slots: " + gym.getNumberOfSlots() +
                    " Status: " + (gym.getGymStatus() ? "Active" : "Inactive") +
                    " City: " + gym.getCity() +
                    " Pincode: " + gym.getPincode());
        }
        return allGyms;
    }

    @Override
    public List<FlipFitGymOwner> viewGymsOwner() {
        List<FlipFitGymOwner> allGymOwners = adminDAO.getAllGymOwners(); // Assuming this method exists in your DAO
        System.out.println("Listing all gym owners:");
        for (FlipFitGymOwner gymOwner : allGymOwners) {
            System.out.println("Owner ID: " + gymOwner.getUserID() + "Owner Name: " + gymOwner.getName() +
                    " Email: " + gymOwner.getEmail() +
                    " Phone Number: " + gymOwner.getPhoneNumber() +
                    " City: " + gymOwner.getCity() +
                    " Pincode: " + gymOwner.getPincode());
        }

        return allGymOwners;
    }



    @Override
    public Boolean login(String username, String password) {
        // Logic to validate user login
        return false; // Replace with actual implementation
    }

    @Override
    public List<FlipFitCustomer> getAllCustomers() {
        List<FlipFitCustomer> allCustomers = adminDAO.getAllCustomers();
        System.out.println("Listing all customers:");
        for (FlipFitCustomer customer : allCustomers) {
            System.out.println("Owner ID: " + customer.getUserID() + "Owner Name: " + customer.getName() +
                    " Email: " + customer.getEmail() +
                    " Phone Number: " + customer.getPhoneNumber() +
                    " City: " + customer.getCity() +
                    " Pincode: " + customer.getPincode());
        }
        return allCustomers;
    }

    @Override
    public List<FlipFitCustomer> getPendingCustomers() {
        // Logic to get pending customers
        List<FlipFitCustomer> pendingCustomers = adminDAO.getPendingCustomers();
        System.out.println("Listing all customers:");
        for (FlipFitCustomer customer : pendingCustomers) {
            System.out.println("Owner ID: " + customer.getUserID() + "Owner Name: " + customer.getName() +
                    " Email: " + customer.getEmail() +
                    " Phone Number: " + customer.getPhoneNumber() +
                    " City: " + customer.getCity() +
                    " Pincode: " + customer.getPincode());
        }
        return pendingCustomers; // Replace with actual implementation
    }

    @Override
    public Object approveCustomers(String customerId) {
        // Logic to approve customers
        boolean flag= adminDAO.approveCustomer(customerId);
        if(flag){
            return "Customer approved successfully";
        }
        else
            return ("Customer not approved");
    }
}
