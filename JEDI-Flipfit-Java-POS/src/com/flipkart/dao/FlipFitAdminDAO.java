package com.flipkart.dao;
import java.util.List;
import com.flipkart.bean.*;

public interface FlipFitAdminDAO {
    public boolean approveGymOwner (String gymOwnerId, boolean status);
    public List<FlipFitGymOwnerDAO> viewPendingGymOwners();
    public List<FlipFitGyms> viewPendingGyms();
    public boolean deleteGyms(String gymId);
    public boolean approveGym(String gymId, boolean status);
    public boolean deleteGymOwners(String gymOwnerId);
    public List<FlipFitGyms> viewGyms();
    public List<FlipFitGyms> viewGymsOwner(int gymOwnerId);
}
