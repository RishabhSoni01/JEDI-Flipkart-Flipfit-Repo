package com.flipkart.rest;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGyms;
import com.flipkart.bean.FlipFitUser;
import com.flipkart.business.FlipFitUserService;
import com.flipkart.business.FlipfitCustomerServiceInterface;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;



@Path("/customer")
public class FlipFitCustomerController {
    private static FlipFitUserService userService = new FlipFitUserService();

    private FlipfitCustomerServiceInterface customerService;

    public FlipFitCustomerController(FlipfitCustomerServiceInterface customerService) {
        this.customerService = customerService;
    }

    /**
     * Endpoint to view gyms in a specified city.
     *
     * @param city The city to search for gyms.
     * @return A response containing the list of gyms or an error message.
     */
    @GET
    @Path("/gyms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewGyms(@QueryParam("city") String city) {
        List<FlipFitGyms> gyms = customerService.viewGyms(city);
        if (gyms != null && !gyms.isEmpty()) {
            return Response.ok(gyms).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No gyms found in the specified city.")
                    .build();
        }
    }

    /**
     * Endpoint to create a new customer profile.
     *
     * @param customer The customer details to be created.
     * @return A response indicating the success or failure of the operation.
     */
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCustomer(FlipFitCustomer customer) {
        try {
            customerService.createCustomer(customer.getName(), customer.getEmail(),
                    customer.getPhoneNumber(), customer.getPassword(),
                    customer.getCity(), customer.getPincode(),
                    customer.getUsername());
            return Response.status(Response.Status.CREATED).entity("Customer created successfully.").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Customer creation failed: " + e.getMessage())
                    .build();
        }
    }

    /**
     * Endpoint to retrieve bookings for a specific user.
     *
     * @param userId The ID of the user to retrieve bookings for.
     * @return A response containing the list of bookings or an error message.
     */
    @GET
    @Path("/bookings")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewBookings(@QueryParam("userId") String userId) {
        List<Booking> bookings = customerService.viewBookings(userId);
        if (bookings != null && !bookings.isEmpty()) {
            return Response.ok(bookings).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No bookings found for the specified user.")
                    .build();
        }
    }

    /**
     * Endpoint to display the profile information of a customer.
     *
     * @param userId The ID of the customer whose profile is to be displayed.
     * @return A response containing the customer's profile or an error message.
     */
    @GET
    @Path("/profile")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewProfile(@QueryParam("userId") String userId) {
        FlipFitCustomer customer = customerService.getCustomerById(userId); // Assuming a method to fetch customer by ID
        System.out.println(customer);
        if (customer != null) {
            return Response.ok(customer).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Customer not found.")
                    .build();
        }
    }

    /**
     * Endpoint to edit the profile of a customer.
     *
     * @param customer The updated customer information.
     * @return A response indicating the success or failure of the operation.
     */
    @PUT
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editProfile(FlipFitCustomer customer) {
        boolean updated = customerService.editProfile(customer);
        if (updated) {
            return Response.ok("Profile updated successfully.").build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Profile update failed.")
                    .build();
        }
    }
}
