package com.flipkart.bean;

import java.time.LocalDateTime;
// Represents a booking made by a user at a gym center.

public class Booking {

    // Unique identifier for this booking.
    private Integer bookingID;
<<<<<<< HEAD

    // The gym center where the booking is made.
    private Integer gymID;

    // The start time of the booking.
    private Integer slotID;
    private LocalDateTime bookingDate;

=======
    private LocalDateTime bookingDate;
>>>>>>> refs/remotes/origin/main
    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }
<<<<<<< HEAD
=======



>>>>>>> refs/remotes/origin/main
    /* Constructor to initialize a Booking object.
    Parameters:

       gymCenter: GymCenter object representing the gym where booking is made.
       starttime: LocalDateTime object representing the start time of the booking.
     */
    public Booking(Integer bookingID, LocalDateTime bookingDate) {
        this.bookingID = bookingID;
        this.bookingDate = bookingDate;
    }


    // Getter for userID.

    // Getter for BookingID.
    public Integer getBookingID() {
        return bookingID;
    }
    // Getter for gymCenter.

}
