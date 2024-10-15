package com.flipkart.app;

import com.flipkart.business.FlipfitCustomerService;
import com.flipkart.business.FlipfitGymOwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.flipkart.rest.FlipFitAdminController;
import com.flipkart.rest.FlipFitCustomerController;
import com.flipkart.rest.FlipFitGymOwnerController;
import com.flipkart.business.FlipfitCustomerServiceInterface;
import com.flipkart.business.FlipfitGymOwnerServiceInterface;


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
    public void run(Configuration configuration, Environment environment) throws Exception {
        LOGGER.info("Registering REST resources");

        // Initialize services
        FlipfitGymOwnerServiceInterface gymOwnerService = new FlipfitGymOwnerService(); // Replace with actual constructor
        FlipfitCustomerServiceInterface customerService = new FlipfitCustomerService(); // Replace with actual constructor

        // Registering REST controllers
        environment.jersey().register(new FlipFitAdminController());
        environment.jersey().register(new FlipFitCustomerController(customerService));
        environment.jersey().register(new FlipFitGymOwnerController(gymOwnerService));
        // Add other controllers as needed
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}
