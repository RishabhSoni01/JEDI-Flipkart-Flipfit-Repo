package com.flipkart.bean;

public class FlipFitUser {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String city;
    private String pincode;
    public String userID;
    public int roleID;
    private String username;

    public FlipFitUser(String userID, String name, String email, String phoneNumber, String password, String city, String pincode, int roleID,String username) {
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
        return password;
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


}
