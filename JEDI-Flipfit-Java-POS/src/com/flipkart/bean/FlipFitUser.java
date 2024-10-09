package com.flipkart.bean;

public class FlipFitUser {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String city;
    private Integer pincode;

    public FlipFitUser(String name, String email, String phoneNumber, String password, String city, Integer pincode) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.city = city;
        this.pincode = pincode;
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

    public Integer getPincode() {
        return pincode;
    }


}
