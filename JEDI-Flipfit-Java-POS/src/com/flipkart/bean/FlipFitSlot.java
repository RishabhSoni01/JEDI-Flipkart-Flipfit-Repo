package com.flipkart.bean;

import java.time.LocalDateTime;

/**
 * Represents a slot in a gym for booking.
 * This class holds details about a specific time slot,
 * including its unique identifier, associated gym, time range,
 * and availability of seats.
 *
 * @author SreeLakshmi
 */
public class FlipFitSlot {

    // Unique identifier for the slot
    private String slotId;

    // Identifier for the gym associated with this slot
    private String gymId;

    // Start time of the slot
    private LocalDateTime startTime;

    // End time of the slot
    private LocalDateTime endTime;

    // Number of available seats in this slot
    private int seatsAvailable;

    /**
     * Constructor to initialize a FlipFitSlot object.
     *
     * @param slotId,gymId,startTime,endTime,seatsAvailable
     */
    public FlipFitSlot(String slotId, String gymId, LocalDateTime startTime, LocalDateTime endTime, int seatsAvailable) {
        this.slotId = slotId;
        this.gymId = gymId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.seatsAvailable = seatsAvailable;
    }

    // Getter and setter methods for each attribute

    public String getGymId() {
        return gymId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }
}
