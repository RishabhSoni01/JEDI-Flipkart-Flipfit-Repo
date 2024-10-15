package com.flipkart.bean;

import java.time.LocalDateTime;

/**
 * Represents a booking made by a user at a gym center.
 * This class contains information about the user, the booking, and the gym associated with the booking.
 *
 * @Author : JEDI-GroupD
 * @Params : This class does not have any parameters.
 * @Exceptions : Raises no exceptions.
 */
public class Booking {
    // Unique identifier of the user making the booking.
    private String userID;

    // Unique identifier for this booking.
    private String bookingID;

    // The gym center where the booking is made.
    private String gymID;

    // The start time of the booking slot.
    private String slotID;

    // The name of the gym center.
    private String gymName;

    // The slot information for the booking.
    private FlipFitSlot slot;

    // The date and time when the booking was made.
    private LocalDateTime bookingDate;

    /**
     * Constructs a Booking object with specified details.
     *
     * @param userID     the unique identifier of the user making the booking.
     * @param bookingID  the unique identifier for this booking.
     * @param gymID      the unique identifier for the gym center.
     * @param slotID     the unique identifier for the booking slot.
     * @param gymName    the name of the gym center.
     * @param slot       the slot details for the booking.
     * @param bookingDate the date and time of the booking.
     */
    public Booking(String userID, String bookingID, String gymID, String slotID, String gymName, FlipFitSlot slot, LocalDateTime bookingDate) {
        this.userID = userID;
        this.bookingID = bookingID;
        this.gymID = gymID;
        this.slotID = slotID;
        this.gymName = gymName;
        this.slot = slot;
        this.bookingDate = bookingDate;
    }

    /**
     * Constructs a Booking object with specified user and booking details.
     *
     * @param userID      the unique identifier of the user making the booking.
     * @param bookingID   the unique identifier for this booking.
     * @param gymID       the unique identifier for the gym center.
     * @param slotID      the unique identifier for the booking slot.
     * @param bookingDate  the date and time of the booking.
     */
    public Booking(String userID, String bookingID, String gymID, String slotID, LocalDateTime bookingDate) {
        this.userID = userID;
        this.bookingID = bookingID;
        this.gymID = gymID;
        this.slotID = slotID;
        this.bookingDate = bookingDate;
    }

    /**
     * Gets the unique identifier of the user making the booking.
     *
     * @return the userID of the user.
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the unique identifier of the user making the booking.
     *
     * @param userID the unique identifier of the user.
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Gets the unique identifier for this booking.
     *
     * @return the bookingID for this booking.
     */
    public String getBookingID() {
        return bookingID;
    }

    /**
     * Sets the unique identifier for this booking.
     *
     * @param bookingID the unique identifier to set for this booking.
     */
    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    /**
     * Gets the unique identifier for the gym center associated with this booking.
     *
     * @return the gymID for the gym center.
     */
    public String getGymID() {
        return gymID;
    }

    /**
     * Sets the unique identifier for the gym center associated with this booking.
     *
     * @param gymID the unique identifier to set for the gym center.
     */
    public void setGymID(String gymID) {
        this.gymID = gymID;
    }

    /**
     * Gets the unique identifier for the booking slot.
     *
     * @return the slotID for the booking slot.
     */
    public String getSlotID() {
        return slotID;
    }

    /**
     * Sets the unique identifier for the booking slot.
     *
     * @param slotID the unique identifier to set for the booking slot.
     */
    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    /**
     * Gets the name of the gym center associated with this booking.
     *
     * @return the gymName of the gym center.
     */
    public String getGymName() {
        return gymName;
    }

    /**
     * Sets the name of the gym center associated with this booking.
     *
     * @param gymName the name to set for the gym center.
     */
    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    /**
     * Gets the slot details for this booking.
     *
     * @return the slot information associated with this booking.
     */
    public FlipFitSlot getSlot() {
        return slot;
    }

    /**
     * Sets the slot details for this booking.
     *
     * @param slot the slot information to set for this booking.
     */
    public void setSlot(FlipFitSlot slot) {
        this.slot = slot;
    }

    /**
     * Gets the date and time of the booking.
     *
     * @return the bookingDate when this booking was made.
     */
    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    /**
     * Sets the date and time of the booking.
     *
     * @param bookingDate the date and time to set for this booking.
     */
    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }
}
