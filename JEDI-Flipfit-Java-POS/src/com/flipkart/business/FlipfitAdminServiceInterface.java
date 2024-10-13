package com.flipkart.business;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitGyms;

import java.util.List;

public interface FlipfitAdminServiceInterface {

    public Object approveGymOwner (String gymOwnerId);
    public List<FlipFitGymOwner> viewPendingGymOwners();
    public List<FlipFitGyms> viewPendingGyms();
    public Object approveGym(String gymId);
    public List<FlipFitGyms> viewGyms();
    public List<FlipFitGymOwner> viewGymsOwner();
    public Boolean login(String username, String password);
    public List<FlipFitCustomer> getAllCustomers();
    public List<FlipFitCustomer> getPendingCustomers();
    public Object approveCustomers(String customerId);
}