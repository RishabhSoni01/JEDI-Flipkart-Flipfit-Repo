package com.flipkart.dao;
import java.util.List;
import com.flipkart.bean.*;

public interface FlipFitAdminDAO {
    public boolean approveGymOwner (String gymOwnerId);
    public boolean approveCustomer (String customerId);
    public List<FlipFitGymOwner> viewPendingGymOwners();
    public List<FlipFitGyms> viewPendingGyms();
    public boolean approveGym(String gymId);
    public List<FlipFitGyms> viewGyms();
    public List<FlipFitGyms> viewGymsOwner(int gymOwnerId);
    public List<FlipFitCustomer> getAllCustomers();
    public List<FlipFitGyms> getPendingCustomers();
}
