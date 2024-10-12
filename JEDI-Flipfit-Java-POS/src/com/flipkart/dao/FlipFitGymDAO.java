package com.flipkart.dao;

import com.flipkart.bean.FlipFitGyms;

import java.util.List;

public interface FlipFitGymDAO {
    public List<FlipFitGyms> findGymsByCity(String city);
}
