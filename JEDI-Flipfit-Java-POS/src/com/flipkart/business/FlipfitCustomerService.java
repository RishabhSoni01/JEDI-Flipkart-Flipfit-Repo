package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.dao.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.UUID;
import com.flipkart.utils.dbutils;
public class FlipfitCustomerService implements FlipfitCustomerServiceInterface {
    public HashMap<String, FlipFitCustomer> customers;
    FlipFitUserService userService=new FlipFitUserService();
    private FlipFitCustomerDAOImplement customerDAO=new FlipFitCustomerDAOImplement();
    private CityDAOImplement cityDAO=new CityDAOImplement();
    Scanner scanner=new Scanner(System.in);


    public void createCustomer(String name, String email, String phone, String password, String city, String pincode, String username) {
        // Create a new role for the customer
        FlipFitRole role = new FlipFitRole(3, "Customer");
        String id = UUID.randomUUID().toString(); // Generate a unique ID for the user/customer
        List<Booking> bookings = new ArrayList<>(); // Assuming Booking class is defined

        // Create a FlipFitCustomer instance
        FlipFitCustomer customer = new FlipFitCustomer(id, name, email, phone, password, city, pincode, 3, username, bookings);

        // Store the customer in a local map (if needed)
        customers.put(id, customer);

        // Create a corresponding FlipFitUser instance
        FlipFitUser user = new FlipFitUser(id, name, email, phone, password, city, pincode, 3, username);

        // Instantiate the DAO implementation
        FlipFitUserDAOImplement userDAO = new FlipFitUserDAOImplement();

        // Add the user to the database
        boolean userAdded = userDAO.addUser(user);
        System.out.println("User added: " + userAdded);

        // If user addition is successful, register the customer
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
    public List<FlipFitGyms> viewGyms(String city){

        return cityDAO.getGymCenters(city);
    }

//    @Override
//    public List<FlipFitSlot> viewSlots(String gymID) {
//        return List.of();
//    }

    @Override
    public List<Booking> viewBookings(String userId) {

        return customerDAO.viewBookings(userId);
    }

//    @Override
//    public boolean addBooking(String userId, String gymId, String slotId, LocalDate bookingDate, LocalTime bookingTime) {
//        return false;
//    }
//
//    @Override
//    public boolean removeBooking(String userId, String gymId, String slotId, LocalDate bookingDate) {
//        return false;
//    }
//
    @Override
    public void viewProfile(FlipFitCustomer customer){
         {
//		Customer customer = customers.get(id);
            if (customer != null) {
                System.out.println("Username: " + customer.getUsername());
                System.out.println("Name: " + customer.getName());
                System.out.println("Email: " + customer.getEmail());
                System.out.println("Phone: " + customer.getPhoneNumber());
                System.out.println("City " + customer.getCity());
                System.out.println("Pincode " + customer.getPincode());
            } else {
                System.out.println("Customer not found.");
            }
        }
    };
//
//    @Override
//    public boolean registerCustomer(String username, String password, String email, String city, String phoneNumber, String pincode, String role) {
//        return false;
//    }
//
//    @Override
//    public boolean changePassword(String username, String oldPassword, String newPassword) {
//        return false;
//    }
//
//    @Override
//    public boolean login(String username, String password) {
//        return false;
//    }
public boolean editProfile(FlipFitCustomer customer) {
    return customerDAO.updateProfile(customer);
}
}
