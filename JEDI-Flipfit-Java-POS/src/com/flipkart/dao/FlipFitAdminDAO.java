package com.flipkart.dao;
import java.util.List;
import com.flipkart.bean.*;

public interface FlipFitAdminDAO {
    // Function to improve the gymOwner request
    public boolean approveGymOwner (String gymOwnerId);
    // Function to improve the Customer
    public boolean approveCustomer (String customerId);
    // Function to list out the pending gym owners
    public List<FlipFitGymOwner> viewPendingGymOwners();
    // Function to list out the pending gyms
    public List<FlipFitGyms> viewPendingGyms();
    // Function to approve a Gym request
    public boolean approveGym(String gymId);
    // Function to list out all the gyms
    public List<FlipFitGyms> viewGyms();
    // Function to list out all the gym owners
    public List<FlipFitGyms> viewGymsOwner(int gymOwnerId);
    // Function to list out all the customers
    public List<FlipFitCustomer> getAllCustomers();
    // Function to list all the pending customers
    public List<FlipFitGyms> getPendingCustomers();
}
