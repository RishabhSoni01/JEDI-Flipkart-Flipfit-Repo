package com.flipkart.dao;

import com.flipkart.bean.FlipFitSlot;

import java.util.List;

public interface FlipFitSlotDAO {
    public List<FlipFitSlot> findFreeSlotsByGymId(String gymId);
}
