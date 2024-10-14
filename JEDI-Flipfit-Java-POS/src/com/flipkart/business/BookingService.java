package com.flipkart.business;
import com.flipkart.bean.*;
import com.flipkart.dao.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookingService implements BookingInterface{
    private FlipfitCustomerService customerService=new FlipfitCustomerService();
    private FlipFitCustomerDAOImplement customerDAO = new FlipFitCustomerDAOImplement();
    public boolean addBooking(String userId, FlipFitGyms gym, FlipFitSlot slot) {

        String booking_id = UUID.randomUUID().toString();
        LocalDateTime bookingDate = slot.getStartTime();
        Booking newbooking = new Booking(userId, booking_id, gym.getGymId(), slot.getSlotId(), bookingDate);
        if(slot.getSeatsAvailable()>0){
//            If slot_sel already exists under current userID in booking --> CancelThisBooking()
            if(customerDAO.bookingExists(newbooking)){
                if(cancelBooking(newbooking.getUserID(), slot.getSlotId())){
                    System.out.println("Previous overlapping booking is cancelled.");
                } else {
                    System.out.println("Previous overlapping booking cancellation Err.");
                }
            }
            if(customerDAO.addBooking(newbooking)){
                customerDAO.updateCapacity(newbooking.getSlotID(), -1);
                System.out.println("Confirm booking at "+ gym.getGymName()+" "+slot.getSlotId()+" successfully added.");
                return true;
            }
//            Write waitlist code
            else return false;
        }
        return false;


    }

    public boolean checkValidBooking(String slotId, String gymId) {
        return false;
    }

    public boolean cancelBooking(String userID, String slotID) {
        // Cancel the booking
        return customerDAO.removeBooking(userID, slotID);
    }

}
