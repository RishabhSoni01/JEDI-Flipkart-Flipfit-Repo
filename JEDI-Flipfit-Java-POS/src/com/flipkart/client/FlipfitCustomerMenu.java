/**
 *
 */
package com.flipkart.client;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGyms;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.business.FlipfitCustomerServiceInterface;
import com.flipkart.business.FlipfitCustomerService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class GymFlipFitCustomerMenu {
    FlipfitCustomerServiceInterface customerService = new FlipfitCustomerService();
    public boolean login (String username, String password) {
        //validate cred from the DB
        customerMainPage();
        return false;
    }

    public void customerMainPage () {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to FlipFit Gym Booking System");
            System.out.println("1. View all gym centers in a city");
            System.out.println("2. View all free slots in a gym on a specific date");
            System.out.println("3. View all bookings in a gym on a specific date");
            System.out.println("4. Book a slot");
            System.out.println("5. Cancel a slot");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();
                    List<FlipFitGyms> gyms = customerService.viewGyms();
                    System.out.println(gyms);  // Assuming FlipFitGym has a toString() method
                    break;
                case 2:
                    System.out.print("Enter gym ID: ");
                    String gymId = scanner.nextLine();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    List<FlipFitSlot> freeSlots = customerService.viewSlots();
                    System.out.println(freeSlots);
                    break;
                case 3:
                    System.out.print("Enter gym ID: ");
                    String gymIdForBookings = scanner.nextLine();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    LocalDate bookingDate = LocalDate.parse(scanner.nextLine());
                    List<Booking> bookings = customerService.viewBookings();
                    System.out.println(bookings);  // Assuming Booking has a toString() method
                    break;
                case 4:
                    System.out.print("Enter user ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter gym ID: ");
                    String gymIdForBooking = scanner.nextLine();
                    System.out.print("Enter slot ID: ");
                    String slotId = scanner.nextLine();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    LocalDate bookingDateForSlot = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter time (HH:MM): ");
                    LocalTime bookingTime = LocalTime.parse(scanner.nextLine());
                    boolean bookingStatus = customerService.addBooking()
                    System.out.println("Booking status: " + (bookingStatus ? "Success" : "Failed"));
                    break;
                case 5:
                    System.out.print("Enter gym ID: ");
                    String gymIdForCancellation = scanner.nextLine();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    LocalDate cancellationDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter time (HH:MM): ");
                    LocalTime cancellationTime = LocalTime.parse(scanner.nextLine());
                    boolean cancellationStatus = customerService.removeBooking();
                    System.out.println("Cancellation status: " + (cancellationStatus ? "Success" : "Failed"));
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}