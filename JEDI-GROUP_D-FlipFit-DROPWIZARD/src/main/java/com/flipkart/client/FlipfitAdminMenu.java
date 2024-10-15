package com.flipkart.client;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.business.FlipFitUserService;
import com.flipkart.business.FlipfitAdminService;
import com.flipkart.exception.CustomerNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;
import com.flipkart.exception.InvalidChoiceException;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
* @author Khushi
* @exceptions InvalidChoice
* */
public class FlipfitAdminMenu {
    Scanner scanner = new Scanner(System.in);
    FlipfitAdminService adminService = new FlipfitAdminService();

    public void adminMainPage(FlipFitUser user) throws InvalidChoiceException {
        int userChoice = -1;

        // Loop until the customer chooses to exit
        while (userChoice!=11) {
            // Display customer menu options
            System.out.println("Admin Menu:");
            System.out.println("1. View Pending Gyms");
            System.out.println("2. View Pending Gym Owners");
            System.out.println("3. Approve gyms request");
            System.out.println("4. Approve gym owners request");
            System.out.println("5. View pending Customers");
            System.out.println("6. Approve Customers request");
            System.out.println("7. View all gyms");
            System.out.println("8. View all gym owners");
            System.out.println("9. View all customers");
            System.out.println("10. Change password");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            userChoice = scanner.nextInt();
            scanner.nextLine();
            switch (userChoice) {
                case 1:adminService.viewPendingGyms();break;
                case 2:adminService.viewPendingGymOwners();break;
                case 3:showGymMenu();break;
                case 4:showGymOwnerMenu();break;
                case 5:adminService.getPendingCustomers();break;
                case 6:showCustomerMenu();break;
                case 7:adminService.viewGyms();break;
                case 8:adminService.viewGymsOwner();break;
                case 9:adminService.getAllCustomers();break;
                case 10:changePassword(user);break;
                case 11: System.out.println("Logging out.");
                    return;
                    default: throw new InvalidChoiceException("Invalid choice. Please try again");
            }
        }

    }
    private void showGymMenu()  {
        int approveChoice = -1;

        // Loop until the admin chooses to go back to the main admin menu
        while (approveChoice != 2) {
            // Display options for approving gym centers
            System.out.println("Approve Gym Center:");
            System.out.println("1. Approve Gym Center by ID");
            System.out.println("2. Back to Admin Menu");
            System.out.print("Enter your choice: ");
            approveChoice = scanner.nextInt();
            scanner.nextLine();

            // Handle admin's choice
            switch (approveChoice) {
                case 1:
                    System.out.print("Enter Gym Center ID: ");
                    String centerId = scanner.nextLine();
                    adminService.approveGym(centerId);
                    break;
                case 2:
                    System.out.println("Returning to Admin Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void showGymOwnerMenu() {
        int approveChoice = -1;

        while (approveChoice != 2) {
            System.out.println("Approve Gym Owner:");
            System.out.println("1. Approve Gym Owner by ID");
            System.out.println("2. Back to Admin Menu");
            System.out.print("Enter your choice: ");

            try {
                approveChoice = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // Clear the invalid input
                continue; // Restart the loop
            }

            switch (approveChoice) {
                case 1:
                    System.out.print("Enter Gym Owner ID: ");
                    String ownerId = scanner.nextLine();
                    try {
                        adminService.approveGymOwner(ownerId);
                        System.out.println("Gym Owner approved successfully.");
                    } catch (GymOwnerNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Returning to Admin Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showCustomerMenu() {
        int approveChoice = -1;

        while (approveChoice != 2) {
            System.out.println("Approve Customer:");
            System.out.println("1. Approve Customer by ID");
            System.out.println("2. Back to Admin Menu");
            System.out.print("Enter your choice: ");

            try {
                approveChoice = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // Clear the invalid input
                continue; // Restart the loop
            }

            switch (approveChoice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    String customerId = scanner.nextLine();
                    try {
                        adminService.approveCustomers(customerId);
                        System.out.println("Customer approved successfully.");
                    } catch (CustomerNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Returning to Admin Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void changePassword(FlipFitUser user) {
        System.out.println("Enter your Old Password");
        String password = scanner.nextLine();
        FlipFitUserService userService = new FlipFitUserService();
        boolean flag = userService.validatePassword(user, password);
        if (flag) {
            System.out.println("Enter your New Password");
            String newPassword = scanner.nextLine();
            System.out.println("Confirm your Password");
            String confirmPassword = scanner.nextLine();
            userService.confirmPassword(user, newPassword, confirmPassword);
        } else {
            System.out.println("Wrong Old Password.");
        }
    }
    }

