package com.flipkart.rest;

import com.codahale.metrics.annotation.Timed;
import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGyms;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitUser;
import com.flipkart.business.FlipFitUserService;
import com.flipkart.business.FlipfitAdminService;
import com.flipkart.business.FlipfitGymOwnerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class FlipFitAdminController {
    private static FlipfitAdminService adminService = new FlipfitAdminService();
    private static FlipfitGymOwnerService gymOwnerService = new FlipfitGymOwnerService();
    private static FlipFitUserService userService = new FlipFitUserService();

    @GET
    @Path("/admin/gym-owner/pending-list")
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
    @Path("/admin/gym-owner/all")
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
    @Path("/admin/gym-centre/pending-list")
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
    @Path("/admin/gym-owner/approve")
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
    @Path("/admin/gym-centre/approve")
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
    @Path("/admin/gym-centre/all")
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
    @Path("/admin/customer/all")
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
    @Path("/admin/customer/pending")
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
    @Path("/admin/customer/approve")
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


    @GET
    @Path("/login")
    public Response adminLogin(@QueryParam("username") String username, @QueryParam("password") String password) {
        try {
            // Attempt to login the user
            FlipFitUser user = userService.login(username, password);

            // Check if the user is not null and is an admin
            if (user != null) {
                if (user.getRole() == 1) { // Check if the user is an admin
                    System.out.println("Login Success for Admin");
//                    return Response.ok("Login Successful").build();
                    return Response.ok(user).build();

                }
                else if (user.getRole() == 2) { // Check if the user is an admin
                    System.out.println("Login Success for GymOwner");
//                    return Response.ok("Login Successful").build();
                    return Response.ok(user).build();
                }
                else if (user.getRole() == 3) { // Check if the user is an admin
                    System.out.println("Login Success for Customer");
//                    return Response.ok("Login Successful").build();
                    return Response.ok(user).build();
                }
                else {
                    return Response.status(Response.Status.UNAUTHORIZED)
                            .entity("Access denied: Not an customer").build();
                }
            } else {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity("Invalid credentials").build();
            }
        } catch (Exception exception) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Login failed: " + exception.getMessage()).build();
        }
    }

}

