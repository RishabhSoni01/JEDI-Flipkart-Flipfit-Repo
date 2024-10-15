package com.flipkart.bean;

import java.time.LocalDateTime;
// Represents a booking made by a user at a gym center.

/**
* @Author : Khushi Srivastava
* @Params : This class does not have any parameters
* @Exceptions : Raises no exceptions
* */
public class Booking {
    // Unique identifier of the user making the booking.
    private String userID;

    // Unique identifier for this booking.
    private String bookingID;

    // The gym center where the booking is made.
    private String gymID;

    public Booking(String userID, String bookingID, String gymID, String slotID, String gymName, FlipFitSlot slot, LocalDateTime bookingDate) {
        this.userID = userID;
        this.bookingID = bookingID;
        this.gymID = gymID;
        this.slotID = slotID;
        this.gymName = gymName;
        this.slot = slot;
        this.bookingDate = bookingDate;
    }

    // The start time of the booking.
    private String slotID;

    private String gymName;
    private FlipFitSlot slot;
    private LocalDateTime bookingDate;
    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public FlipFitSlot getSlot() {
        return slot;
    }

    public void setSlot(FlipFitSlot slot) {
        this.slot = slot;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    /* Constructor to initialize a Booking object.
    Parameters:
       userID: ID of the user making the booking.
       bookingID: Unique ID for this booking.
       gymCenter: GymCenter object representing the gym where booking is made.
       starttime: LocalDateTime object representing the start time of the booking.
     */
    public Booking(String userID, String bookingID, String gymID, String slotID, LocalDateTime bookingDate) {
        this.userID = userID;
        this.bookingID = bookingID;
        this.gymID = gymID;
        this.slotID = slotID;
        this.bookingDate = bookingDate;
    }


    // Getter for userID.
    public String getUserID() {
        return userID;
    }

    // Setter for userID.
    public void setUserID(String userID) {
        this.userID = userID;
    }

    // Getter for BookingID.
    public String getBookingID() {
        return bookingID;
    }

    // Setter for BookingID.
    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    // Getter for gymCenter.
    public String getGymID() { return gymID; }

    // Setter for gymCenter.
    public void setGymID(String gymID) {
        this.gymID = gymID;
    }

    public String getSlotID() { return slotID; }

    public void setSlotID(String slotID) { this.slotID = slotID; }

}