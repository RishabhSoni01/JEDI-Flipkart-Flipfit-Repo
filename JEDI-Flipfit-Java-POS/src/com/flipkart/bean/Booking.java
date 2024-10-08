package com.flipkart.bean;

import java.time.LocalDateTime;
// Represents a booking made by a user at a gym center.

public class Booking {

    // Unique identifier for this booking.
    private Integer bookingID;
    // The gym center where the booking is made.
    private LocalDateTime bookingDate;
    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }
    /* Constructor to initialize a Booking object.
    Parameters:
       userID: ID of the user making the booking.
       bookingID: Unique ID for this booking.
       gymCenter: GymCenter object representing the gym where booking is made.
       starttime: LocalDateTime object representing the start time of the booking.
     */
    public Booking(Integer bookingID,  LocalDateTime bookingDate) {
        this.bookingID = bookingID;

        this.bookingDate = bookingDate;
    }


    // Getter for BookingID.
    public Integer getBookingID() {
        return bookingID;
    }
    // Getter for gymCenter.


}
