package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGyms;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.dao.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class FlipfitCustomerService implements FlipfitCustomerServiceInterface {
    private final FlipFitGymDAO gymDAO = new FlipFitGymDAOImplement();
    private final FlipFitSlotDAO slotDAO = new FlipFitSlotDAOImplement();
    private FlipFitCustomerDAO customerDAO = new FlipFitCustomerDAOImplement();
    /*
    * Function to return all the gyms in the given city
    * */
    @Override
    public List<FlipFitGyms> viewGyms(String city){

        List<FlipFitGyms> gyms = gymDAO.findGymsByCity(city);
        return gyms != null ? gyms : List.of();
    }
    /*
     * Returns a list of all free slots in a given gym
     */

    @Override
    public List<FlipFitSlot> viewSlots(String gymID) {
        List<FlipFitSlot> slots = slotDAO.findFreeSlotsByGymId(gymID);
        return slots != null ? slots : List.of();
    }

    @Override
    public List<Booking> viewBookings(String userId) {
        return customerDAO.viewBookings(userId);
    }

    @Override
    public boolean addBooking(String userId, String bookingId,String gymId, String slotId) {
        return customerDAO.addBooking(userId,bookingId, gymId, slotId);
    }

    @Override
    public boolean removeBooking(String userId, String gymId, String slotId, LocalDate bookingDate) {
        return customerDAO.removeBooking(userId, gymId, slotId, bookingDate);
    }

    @Override
    public FlipFitCustomer viewProfile(String userId){
        return customerDAO.viewProfile(userId);
    };

    @Override
    public boolean registerCustomer(String username, String password, String email, String city, String phoneNumber, String pincode, String role) {
        return customerDAO.registerCustomer(username, password, email, city, phoneNumber, pincode, role);
    }

    @Override
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        return customerDAO.changePassword(username, oldPassword, newPassword);
    }

    @Override
    public boolean login(String username, String password) {
        return customerDAO.login(username, password);
    }
}
