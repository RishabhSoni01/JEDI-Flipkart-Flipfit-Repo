package com.flipkart.bean;

public class FlipFitUser {
    private String name;
    private String email;

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
        this.password = password;
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
