package com.flipkart.bean;
import java.util.ArrayList;
import java.util.List;
/**
 * Represents an admin user in the FlipFit system, extending FlipFitUser.
 * This class provides a default constructor initializing admin details.
 */
public class FlipFitCustomer extends FlipFitUser {

    /**
     * Default constructor for creating an admin user.
     * Initializes with default values for admin user ID, username, email, password,
     * and assigns the role as ADMIN.
     */
    private List<pair<Booking, Boolean>> bookings;
    public FlipFitCustomer(String userID, String name, String email, String phoneNumber, String password, String city, String pincode, int role,String username) {
        super(userID, name, email, phoneNumber, password, city, pincode, role,username);

    }
    public List<pair<Booking, Boolean>> getBookings() {
        return bookings;
    }

    // Setter for bookings.
    public void setBookings(List<pair<Booking, Boolean>> bookings) {
        this.bookings = bookings;
    }
}

