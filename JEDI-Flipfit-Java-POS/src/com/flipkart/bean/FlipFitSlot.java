package com.flipkart.bean;
import java.time.LocalDateTime;
public class FlipFitSlot {
    private String slotId;

    public FlipFitSlot(String slotId, String gymId, LocalDateTime startTime, LocalDateTime endTime, int seatsAvailable) {
        this.slotId = slotId;
        this.gymId = gymId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.seatsAvailable = seatsAvailable;
    }

    private String gymId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int seatsAvailable;
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
