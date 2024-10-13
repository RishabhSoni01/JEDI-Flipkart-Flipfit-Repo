package com.flipkart.business;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitUser;
import com.flipkart.dao.FlipFitUserDAO;
import com.flipkart.dao.FlipFitUserDAOImplement;
import java.util.HashMap;
public class FlipFitUserService {
    static HashMap<String, FlipFitUser> UsersMap = new HashMap<>();
    private FlipFitUserDAOImplement flipFitUserDAOImplement = new FlipFitUserDAOImplement();
    private FlipFitUserDAO userDAO = new FlipFitUserDAOImplement();
    public void addUser(FlipFitUser user){
        UsersMap.put(user.getUsername(), user);
    };

    /**
     * Authenticates a user with the given username and password.
     */
    public FlipFitUser login(String username, String password){
        return flipFitUserDAOImplement.validateUser(username, password);
    };

    public boolean validatePassword(FlipFitUser user, String oldPassword){
        return user.getPassword().equals(oldPassword);
    };

    public void confirmPassword(FlipFitUser user, String newPassword, String confirmPassword){
        if (newPassword.equals(confirmPassword)) {
            user.setPassword(newPassword);
            if(userDAO.updateUser(user)){
                System.out.println("Password Changed Successfully");
            }
        } else {
            System.out.println("Password did not match");
        }
    };

    boolean registerGymOwner(FlipFitGymOwner gymOwner){
        return userDAO.registerGymOwner(gymOwner);
    };

    boolean registerCustomer(FlipFitCustomer customer){
        return userDAO.registerCustomer(customer);
    };
}
