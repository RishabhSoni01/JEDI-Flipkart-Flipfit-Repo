package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitUser;

public interface FlipFitUserDAO {
    public FlipFitUser validateUser(String username, String password);
    public boolean registerGymOwner(FlipFitGymOwner gymOwner);
    public boolean registerCustomer(FlipFitCustomer customer);
    public boolean updateUser(FlipFitUser user);
}
