/**
 *
 */
package com.flipkart.client;

import com.flipkart.bean.*;
import com.flipkart.business.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class FlipfitCustomerMenu {
    FlipfitCustomerServiceInterface customerService = new FlipfitCustomerService();

    private Scanner scanner = new Scanner(System.in);
    public void customerMainPage () {
        int userChoice = -1;

        // Loop until the customer chooses to exit
        while (userChoice!=7) {
            // Display customer menu options
            System.out.println("Customer Menu:");
            System.out.println("1. View Profile");
            System.out.println("2. Edit Profile");
            System.out.println("3. Book Slot");
            System.out.println("4. View Bookings");
            System.out.println("5. Cancel Booking");
            System.out.println("6. Change Password");
            System.out.println("7. Logout");
            System.out.print("Enter your choice: ");
            userChoice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            // Handle customer's choice
//            switch (userChoice) {
//                case 1:
//                    customerService.viewProfile();
//                    break;
//                case 2:
//                    editProfile(customer);
//                    break;
//                case 3:
//                    addbookings(customer);
//                    break;
//                case 4:
//                    viewBookings(customer.getUserid());
//                    break;
//                case 5:
//                    cancelbookings(customer.getUserid());
//                    break;
//                case 6:
//                    changePassword(customer);
//                    break;
//                case 7:
//                    System.out.println("Logging Out!");
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
        }
    }
}


