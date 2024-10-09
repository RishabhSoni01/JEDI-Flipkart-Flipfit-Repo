package com.flipkart.bean;
import java.util.ArrayList;
import java.util.List;
public class FlipFitCustomer extends FlipFitUser{

    private int customerId;
    private List<pair<Booking, Boolean>> bookings;
    public FlipFitCustomer(String name, String email, String phoneNumber, String password, String city, Integer pincode) {
        super(name, email, phoneNumber, password, city, pincode);
    }
    public int getCustomerId() {
        return customerId;
    }

    public List<pair<Booking, Boolean>> getBookings() {
        return bookings;
    }
}
