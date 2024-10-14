package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitGyms;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.bean.FlipFitUser;

import java.time.LocalDateTime;
import java.util.List;

public interface FlipFitGymOwnerDAO {
    public boolean updateProfile(FlipFitGymOwner gymOwner);
    public FlipFitGymOwner getGymOwner(FlipFitUser user);
    public void removeSlot(String gymID, LocalDateTime starttime);
    public boolean isSlotExists(String gymID, FlipFitSlot slot);
    public void addSlots(String gymID, FlipFitSlot slot);
    public List<FlipFitGyms> getGymCenters(String userid);
    public boolean addGymCenter(FlipFitGyms gymCenter);
}
