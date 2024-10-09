package com.flipkart.bean;

import java.time.LocalDateTime;
// Represents a booking made by a user at a gym center.

public class Booking {

    // Unique identifier for this booking.
    private Integer bookingID;
<<<<<<< HEAD


=======
>>>>>>> refs/remotes/origin/main
    // The gym center where the booking is made.
    private LocalDateTime bookingDate;
<<<<<<< HEAD

=======
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
       userID: ID of the user making the booking.
       bookingID: Unique ID for this booking.
       gymCenter: GymCenter object representing the gym where booking is made.
       starttime: LocalDateTime object representing the start time of the booking.
     */
    public Booking(Integer userID, Integer bookingID, Integer gymID, Integer slotID, LocalDateTime bookingDate) {
        this.customerId = userID;
        this.bookingID = bookingID;
        this.gymID = gymID;
        this.slotID = slotID;
        this.bookingDate = bookingDate;
    }


    // Getter for userID.
    public Integer getUserID() {
        return customerId;
    }

    // Getter for BookingID.
    public Integer getBookingID() {
        return bookingID;
    }
    // Getter for gymCenter.
    public Integer getGymID() {
        return gymID; }


    public Integer getSlotID() { return slotID; }


}
