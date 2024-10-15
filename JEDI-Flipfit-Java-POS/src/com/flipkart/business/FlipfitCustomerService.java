package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.dao.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class FlipfitCustomerService implements FlipfitCustomerServiceInterface {
    // Map to store customers
    public HashMap<String, FlipFitCustomer> customers;

    // Services and DAOs for user and customer management
    FlipFitUserService userService = new FlipFitUserService();
    private FlipFitCustomerDAOImplement customerDAO = new FlipFitCustomerDAOImplement();
    private CityDAOImplement cityDAO = new CityDAOImplement();
    Scanner scanner = new Scanner(System.in);

    /**
     * Creates a new customer account.
     *
     * @param name,email,phone,password,city,pincode,username
     */
    public void createCustomer(String name, String email, String phone, String password, String city, String pincode, String username) {
        // Create a new role for the customer
        FlipFitRole role = new FlipFitRole(3, "Customer");
        String id = UUID.randomUUID().toString(); // Generate a unique ID for the user/customer
        List<Booking> bookings = new ArrayList<>(); // Initialize a list for bookings

        // Create a FlipFitCustomer instance
        FlipFitCustomer customer = new FlipFitCustomer(id, name, email, phone, password, city, pincode, 3, username, bookings);

        // Store the customer in a local map
        customers.put(id, customer);

        // Create a corresponding FlipFitUser instance
        FlipFitUser user = new FlipFitUser(id, name, email, phone, password, city, pincode, 3, username);

        // Instantiate the DAO implementation
        FlipFitUserDAOImplement userDAO = new FlipFitUserDAOImplement();

        // Add the user to the database
        boolean userAdded = userDAO.addUser(user);
        System.out.println("User added: " + userAdded);

        // Register the customer if user addition is successful
        boolean customerRegistered = false;
        if (userAdded) {
            customerRegistered = userDAO.registerCustomer(customer);
            System.out.println("Customer registered: " + customerRegistered);
        }

        // Log the outcome of the creation process
        if (userAdded && customerRegistered) {
            System.out.println("Customer created successfully");
        } else {
            System.out.println("Customer creation failed");
        }
    }

    @Override
    public List<FlipFitGyms> viewGyms(String city) {
        // Retrieve and return gyms in the specified city
        return cityDAO.getGymCenters(city);
    }

    @Override
    public List<Booking> viewBookings(String userId) {
        // Retrieve and return bookings for the specified user
        return customerDAO.viewBookings(userId);
    }

    @Override
    public void viewProfile(FlipFitCustomer customer) {
        // Display the profile information for the given customer
        if (customer != null) {
            System.out.println("Username: " + customer.getUsername());
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone: " + customer.getPhoneNumber());
            System.out.println("City: " + customer.getCity());
            System.out.println("Pincode: " + customer.getPincode());
        } else {
            System.out.println("Customer not found.");
        }
    }

    public boolean editProfile(FlipFitCustomer customer) {
        // Update the customer's profile information in the database
        return customerDAO.updateProfile(customer);
    }
}
