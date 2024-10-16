package com.flipkart.app;

import com.flipkart.business.*;
import com.flipkart.rest.FlipFitBookingController;
import com.flipkart.rest.FlipFitAdminController;
import com.flipkart.rest.FlipFitCustomerController;
import com.flipkart.rest.FlipFitGymOwnerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Main application class to run the Dropwizard application.
 */
public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        // Initialization logic can go here if needed
    }

    @Override
    public void run(Configuration configuration, Environment environment) {
        LOGGER.info("Registering REST resources");

        // Initialize services
        FlipfitGymOwnerServiceInterface gymOwnerService = new FlipfitGymOwnerService();
        FlipfitCustomerServiceInterface customerService = new FlipfitCustomerService();
        BookingInterface bookingService = new BookingService();

        // Registering REST controllers
        environment.jersey().register(new FlipFitAdminController());
        environment.jersey().register(new FlipFitCustomerController(customerService));
        environment.jersey().register(new FlipFitGymOwnerController(gymOwnerService));
        environment.jersey().register(new FlipFitBookingController(bookingService, customerService));

        // Add other controllers as needed
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}
