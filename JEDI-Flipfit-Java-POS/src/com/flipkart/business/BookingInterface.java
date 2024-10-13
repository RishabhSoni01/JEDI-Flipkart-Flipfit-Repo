package com.flipkart.business;

import com.flipkart.bean.FlipFitGyms;
import com.flipkart.bean.FlipFitSlot;

public interface BookingInterface {
    public boolean addBooking (String userId, FlipFitGyms gyms, FlipFitSlot slot);
    public boolean checkValidBooking (String slotId, String gymId);
    public boolean cancelBooking (String bookingId);
}