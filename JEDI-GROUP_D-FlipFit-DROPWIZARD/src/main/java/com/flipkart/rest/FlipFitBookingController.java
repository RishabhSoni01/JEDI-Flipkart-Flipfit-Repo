package com.flipkart.rest;

import com.flipkart.bean.*;
import com.flipkart.dao.CityDAO;
import com.flipkart.exception.BookingFailedException;
import com.flipkart.exception.GymNotFoundException;
import com.flipkart.business.BookingInterface;
import com.flipkart.business.FlipfitCustomerServiceInterface;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Scanner;

@Path("/bookings")
public class FlipFitBookingController {

    private BookingInterface bookingService;
    private FlipfitCustomerServiceInterface customerService;
    private final Scanner scanner = new Scanner(System.in);

    public FlipFitBookingController(BookingInterface bookingService, FlipfitCustomerServiceInterface customerService) {
        this.bookingService = bookingService;
        this.customerService = customerService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBooking(FlipFitCustomer customer) {
        try {
            // Get all available cities
            List<City> cities = CityDAO.getAllCities();
            if (cities.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No cities available.")
                        .build();
            }

            // Print available cities
            cities.forEach(city -> System.out.println(city.getCityName()));

            System.out.print("Enter City: ");
            String city = scanner.nextLine();

            List<FlipFitGyms> gymCenters = customerService.viewGyms(city.toLowerCase());

            // Check if there are any gym centers available
            if (gymCenters.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No gyms found for the city: " + city)
                        .build();
            }

            // Print available gyms
            gymCenters.forEach(gymCenter -> System.out.println(gymCenter.getGymName()));

            System.out.print("Enter Gym Name: ");
            String gymName = scanner.nextLine();
            FlipFitGyms selectedGym = gymCenters.stream()
                    .filter(gc -> gc.getGymName().equalsIgnoreCase(gymName))
                    .findFirst()
                    .orElse(null);

            if (selectedGym != null) {
                List<FlipFitSlot> slots = selectedGym.getSlot();

                // Check if the selected gym has any slots available
                if (slots.isEmpty()) {
                    return Response.status(Response.Status.NOT_FOUND)
                            .entity("No slots available for this gym center.")
                            .build();
                }

                // Print available slots
                slots.forEach(slot -> System.out.printf("Start time: %s, End time: %s, Capacity: %d%n",
                        slot.getStartTime(), slot.getEndTime(), slot.getSeatsAvailable()));

                System.out.print("Choose a slot (enter the number): ");
                int choice = scanner.nextInt();
                FlipFitSlot selectedSlot = slots.get(choice - 1);

                // Attempt to add booking
                if (bookingService.addBooking(customer.getUserID(), selectedGym, selectedSlot)) {
                    return Response.status(Response.Status.CREATED)
                            .entity("Booking successful!")
                            .build();
                } else {
                    throw new BookingFailedException("Booking failed!");
                }
            } else {
                throw new GymNotFoundException(gymName);
            }
        } catch (GymNotFoundException | BookingFailedException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An unexpected error occurred: " + e.getMessage())
                    .build();
        }
    }

/**
     * Endpoint to check if a booking is valid.
     *
     * @param slotId The ID of the time slot to check.
     * @param gymId The ID of the gym.
     * @return A response indicating whether the booking is valid.
     */
    @GET
    @Path("/validate")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkValidBooking(@QueryParam("slotId") String slotId, @QueryParam("gymId") String gymId) {
        boolean isValid = bookingService.checkValidBooking(slotId, gymId);
        if (isValid) {
            return Response.ok("Booking is valid.").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Booking is not valid.").build();
        }
    }

    /**
     * Endpoint to cancel a booking.
     *
     * @param userId The ID of the user requesting the cancellation.
     * @param slotId The ID of the slot to cancel.
     * @return A response indicating the success or failure of the cancellation operation.
     */
    @DELETE
    @Path("/cancel")
    public Response cancelBooking(@QueryParam("userId") String userId, @QueryParam("slotId") String slotId) {
        boolean success = bookingService.cancelBooking(userId, slotId);
        if (success) {
            return Response.ok("Booking cancelled successfully.").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Cancellation failed.").build();
        }
    }
}
