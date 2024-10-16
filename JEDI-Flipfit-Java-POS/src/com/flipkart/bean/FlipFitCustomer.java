package com.flipkart.bean;
import java.util.ArrayList;
import java.util.List;
/**
 * Represents an admin user in the FlipFit system, extending FlipFitUser.
 * This class provides a default constructor initializing admin details.
 * @author Mukul
 */
public class FlipFitCustomer extends FlipFitUser {

    /**
     * Default constructor for creating an admin user.
     * Initializes with default values for admin user ID, username, email, password,
     * and assigns the role as ADMIN.
     */
    private List<pair<Booking, Boolean>> bookings;

    public int getApproval() {
        return approval;
    }

    public void setApproval(int approval) {
        this.approval = approval;
    }

    private int approval;

    /**
     * Default constructor for creating a customer.
     *
     * @param userID,name,email,phoneNumber,password,city,pincode,role,username,bookings
     */

    public FlipFitCustomer(String userID, String name, String email, String phoneNumber, String password, String city, String pincode, int role,String username,List<Booking> bookings) {
        super(userID, name, email, phoneNumber, password, city, pincode, role,username);
        this.bookings = new ArrayList<>();

    }
    public List<pair<Booking, Boolean>> getBookings() {
        return bookings;
    }

    // Setter for bookings.
    public void setBookings(List<pair<Booking, Boolean>> bookings) {
        this.bookings = bookings;
    }

}

