package com.flipkart.rest;

import com.codahale.metrics.annotation.Timed;
import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGyms;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.business.FlipfitAdminService;
import com.flipkart.business.FlipfitGymOwnerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class FlipFitAdminController {
    private static FlipfitAdminService adminService = new FlipfitAdminService();
    private static FlipfitGymOwnerService gymOwnerService = new FlipfitGymOwnerService();

    @GET
    @Path("/gym-owner/pending-list")
    @Timed
    public Response viewPendingGymOwners() {
        try {
            List<FlipFitGymOwner> gymOwnerList = adminService.viewPendingGymOwners();
            return Response.ok(gymOwnerList).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/gym-owner/all")
    @Timed
    public Response viewGymOwners() {
        try {
            List<FlipFitGymOwner> gymOwnerList = adminService.viewGymsOwner();
            return Response.ok(gymOwnerList).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/gym-centre/pending-list")
    @Timed
    public Response viewPendingGymCentres() {
        try {
            List<FlipFitGyms> gymCentreList = adminService.viewPendingGyms();
            return Response.ok(gymCentreList).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/gym-owner/handle")
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public Response handleGymOwner(@QueryParam("id") String gymOwnerId) {
        try {
            adminService.approveGymOwner(gymOwnerId);
            return Response.ok("Gym Owner approved successfully").build();
        } catch (Exception e) {
            return Response.status(400).entity("Invalid Gym Owner details").build();
        }
    }

    @POST
    @Path("/gym-centre/handle")
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public Response handleGymCentre(@QueryParam("id") String gymId) {
        try {
            adminService.approveGym(gymId);
            return Response.ok("Gym approved successfully").build();
        } catch (Exception e) {
            return Response.status(400).entity("Invalid Gym Centre details").build();
        }
    }

    @GET
    @Path("/gym-centre/all")
    @Timed
    public Response viewGyms() {
        try {
            List<FlipFitGyms> allGyms = adminService.viewGyms();
            return Response.ok(allGyms).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/customer/all")
    @Timed
    public Response getAllCustomers() {
        try {
            List<FlipFitCustomer> allCustomers = adminService.getAllCustomers();
            return Response.ok(allCustomers).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/customer/pending")
    @Timed
    public Response getPendingCustomers() {
        try {
            List<FlipFitCustomer> pendingCustomers = adminService.getPendingCustomers();
            return Response.ok(pendingCustomers).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/customer/approve")
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public Response approveCustomer(@QueryParam("id") String customerId) {
        try {
            Object response = adminService.approveCustomers(customerId);
            return Response.ok(response).build();
        } catch (Exception e) {
            return Response.status(400).entity("Invalid Customer ID").build();
        }
    }

    @POST
    @Path("/login")
    @Timed
    public Response login(@QueryParam("username") String username, @QueryParam("password") String password) {
        try {
            Boolean isAuthenticated = adminService.login(username, password);
            if (isAuthenticated) {
                return Response.ok("Login Successful").build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }
}
