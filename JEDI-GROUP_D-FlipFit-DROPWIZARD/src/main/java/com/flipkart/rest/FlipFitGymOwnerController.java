package com.flipkart.rest;

import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitGyms;
import com.flipkart.bean.FlipFitUser;
import com.flipkart.business.FlipFitUserService;
import com.flipkart.business.FlipfitGymOwnerServiceInterface;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/gymOwner")
public class FlipFitGymOwnerController {
    private static FlipFitUserService userService = new FlipFitUserService();
    private FlipfitGymOwnerServiceInterface gymOwnerService;

    public FlipFitGymOwnerController(FlipfitGymOwnerServiceInterface gymOwnerService) {
        this.gymOwnerService = gymOwnerService;
    }

    /**
     * Endpoint to create a new gym owner profile.
     *
     * @param gymOwner The gym owner details to be created.
     * @return A response indicating the success or failure of the operation.
     */
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createGymOwner(FlipFitGymOwner gymOwner) {
        System.out.println(gymOwner.getPanCard());
        try {
            gymOwnerService.createGymOwner(gymOwner.getName(), gymOwner.getEmail(),
                    gymOwner.getPhoneNumber(), gymOwner.getPassword(),
                    gymOwner.getCity(), gymOwner.getPincode(), gymOwner.getUsername(),
                    gymOwner.getPanCard(), gymOwner.getAadhar(), gymOwner.getGST());
            return Response.status(Response.Status.CREATED).entity("Gym Owner created successfully.").build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Input error: " + e.getMessage()).build();
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace(); // For debugging
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Gym Owner creation failed: " + e.getMessage()).build();
        }
    }


    /**
     * Endpoint to add a new gym center associated with a gym owner.
     *
     * @param userId The ID of the gym owner.
     * @param gymCenter The gym center details to be added.
     * @return A response indicating the success or failure of the operation.
     */
    @POST
    @Path("/{userId}/addGymCenter")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGymCenter(@PathParam("userId") String userId, FlipFitGyms gymCenter) {
        FlipFitGymOwner gymOwner = new FlipFitGymOwner(userId, "", "", "", "", "", "", 0, "", "", "", "");
        boolean success = gymOwnerService.addGymCenter(gymOwner,
                gymCenter.getGymName(), gymCenter.getNumberOfSlots(), gymCenter.getCity(), gymCenter.getPincode());
        if (success) {
            return Response.status(Response.Status.CREATED).entity("Gym Center added successfully.").build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to add Gym Center.").build();
        }
    }

    @GET
    @Path("/{userId}/gyms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showGymCenters(@PathParam("userId") String userId) {
        // Create a FlipFitGymOwner object using the userId
        FlipFitGymOwner gymOwner = new FlipFitGymOwner(userId, "", "", "", "", "", "", 0, "", "", "", "");

        // Call the service to get gym centers
        List<FlipFitGyms> gymCenters = gymOwnerService.showGymCenters(gymOwner);

        if (gymCenters != null && !gymCenters.isEmpty()) {
            return Response.ok(gymCenters).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No gym centers found for the specified gym owner.")
                    .build();
        }
    }


    /**
     * Endpoint to edit the profile of a gym owner.
     *
     * @param gymOwner The updated gym owner information.
     * @return A response indicating the success or failure of the operation.
     */
    @PUT
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editProfile(FlipFitGymOwner gymOwner) {
        boolean updated = gymOwnerService.editProfile(gymOwner);
        if (updated) {
            return Response.ok("Profile updated successfully.").build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Profile update failed.")
                    .build();
        }
    }

    /**
     * Endpoint to manage slots for a gym center.
     *
     * @param userId The ID of the gym owner.
     * @return A response indicating the success or failure of the operation.
     */
    @PUT
    @Path("/{userId}/editSlots")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editSlots(@PathParam("userId") String userId, FlipFitGyms gymCenter) {
        try {
            gymOwnerService.editSlots(new FlipFitGymOwner(userId, "", "", "", "", "", "", 0, "", "", "", ""));
            return Response.ok("Slots managed successfully.").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to manage slots: " + e.getMessage())
                    .build();
        }
    }
}
