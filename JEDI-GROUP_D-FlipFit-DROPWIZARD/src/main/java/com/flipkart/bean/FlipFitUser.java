package com.flipkart.bean;

/**
 * Represents a user in the FlipFit application.
 * This class holds details about a user, including personal information,
 * contact details, authentication credentials, and role within the system.
 *
 * @author Kabir
 */
public class FlipFitUser {

    // User's name
    private String name;

    // User's email address
    private String email;

    // User's phone number
    private String phoneNumber;

    // User's password (should be handled securely)
    private String password;

    // User's city of residence
    private String city;

    // User's postal code
    private String pincode;

    // Unique identifier for the user
    public String userID;

    // Role identifier to distinguish between different user types (e.g., customer, gym owner)
    public int roleID;

    // Username for login purposes
    private String username;

    /**
     * Constructor to initialize a FlipFitUser object with necessary details.
     *
     * @param userID,name,email,phoneNumber,password,city,pincode,roleID,username
     */
    public FlipFitUser(String userID, String name, String email, String phoneNumber,
                       String password, String city, String pincode, int roleID, String username) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.city = city;
        this.pincode = pincode;
        this.roleID = roleID;
        this.username = username;
    }

    // Getter methods for each attribute
    public FlipFitUser() {
        // Initialize with default values if necessary
    }
    public String getUserID() {
        return userID;
    }

    public int getRole() {
        return roleID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password; // Consider securing this method
    }

    public String getCity() {
        return city;
    }

    public String getPincode() {
        return pincode;
    }

    public String getUsername() {
        return username;
    }

    // Setter methods for each attribute

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password; // Consider validating or securing this method
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
