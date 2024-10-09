package com.flipkart.client;

import com.flipkart.business.FlipfitAdminService;
import com.flipkart.business.FlipfitCustomerService;
import com.flipkart.business.FlipfitGymOwnerService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;


public class GymFlipFitApplication {
    public static void main(String[] args) {
        homePage();
    }


    private static FlipfitCustomerMenu customerMenu = new FlipfitCustomerMenu();
    private static FlipfitAdminMenu adminMenu = new FlipfitAdminMenu();
    private static FlipfitGymOwnerMenu gymOwnerMenu = new FlipfitGymOwnerMenu();

    private static void homePage() {
        System.out.println("Welcome to FlipFit App!!\n");
        System.out.println("Choose a option : \n1: Enter to login\n2:Enter to register as Customer\n3:Enter to register as Gym " +
                "Owner\n4: Change Password\n5: Exit");
        try{
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    login();
                    break;
                case 2:
                    registerAsCustomer();
                    break;
                case 3:
                    registerGymOwner();
                    break;
                case 4:
                    changePassword();
                    break;
                case 5:
                    System.out.println("Exiting FlipFit App. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please choose a valid option");
            }
        } catch(Exception e){
            System.out.println("You have entered an invalid option or there is some internal server error!");
        }
    }

    private static void login() {
        System.out.println("Please Choose : \n1: Enter 1 to login as Admin\n2: Enter 2 to login as Customer\n3: " +
                "Enter 3 to login as GymOwner");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if(choice == 1) {
            System.out.println("Enter your UserID");
            Integer userID = scanner.nextInt();

            System.out.println("Enter your Passkey");
            String password = scanner.next();
            System.out.println("Enter your Role");
            String role = scanner.next();
            FlipfitAdminService.login(userID, password, role);
            adminMenu.adminMainPage();
        }
        else if (choice == 2) {
            System.out.println("Enter your UserID");
            Integer userID = scanner.nextInt();
            System.out.println("Enter your Passkey");
            String password = scanner.next();
            System.out.println("Enter your Role");
            String role = scanner.next();
            FlipfitCustomerService.login(userID, password, role);
            customerMenu.customerMainPage();
        }
        else if (choice == 3) {
            System.out.println("Enter your UserID");
            Integer userID = scanner.nextInt();
            System.out.println("Enter your Passkey");
            String password = scanner.next();
            System.out.println("Enter your Role");
            String role = scanner.next();
            FlipfitGymOwnerService.login(userID, password, role);
            gymOwnerMenu.gymOwnerMainPage();
        }
        else {
            System.out.println("Please choose a valid option");
        }
    }

    private static void registerAsCustomer() {
        Scanner scanner = new Scanner(System.in);

        // Input for registration details
        System.out.print("Enter userID: ");
        Integer userID = scanner.nextInt();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter pincode: ");
        String pincode = scanner.nextLine();



        // Call the registerCustomer method with the collected inputs
        boolean registrationSuccess = FlipfitCustomerService.registerCustomer(userID, password, email, city, phoneNumber, pincode, "Customer");

        if (registrationSuccess) {
            System.out.println("Customer registration successful!");
        } else {
            System.out.println("Customer registration failed. Please try again.");
        }

    }

    private static void registerGymOwner() {
        Scanner scanner = new Scanner(System.in);

        // Input for registration details
        System.out.print("Enter userID: ");
        Integer userID = scanner.nextInt();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter pincode: ");
        String pincode = scanner.nextLine();

        System.out.print("Enter aadhar card number: ");
        String aadharCardNumber = scanner.nextLine();

        System.out.print("Enter pan card number: ");
        String panCardNumber = scanner.nextLine();

        System.out.print("Enter GST number: ");
        String gst = scanner.nextLine();

        System.out.print("Enter gym center id: ");
        Integer gymCenterId = scanner.nextInt();
        List<Integer> gymCenters = new ArrayList<>();
        gymCenters.add(gymCenterId);
        boolean registrationSuccess = FlipfitGymOwnerService.register(userID, email, password, city, phoneNumber, pincode, aadharCardNumber, panCardNumber, gst, gymCenters,"Owner");

        if (registrationSuccess) {
            System.out.println("Customer registration successful!");
        } else {
            System.out.println("Customer registration failed. Please try again.");
        }
    }

    private static void changePassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter old password: ");
        String oldPassword = scanner.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        System.out.println("\nEnter your role:");
        System.out.println("1: Customer");
        System.out.println("2: GymOwner");
        System.out.println("3: Admin");

        try {
            int roleChoice = scanner.nextInt();

            switch(roleChoice) {
                case 1:
                    System.out.println("You selected Customer role.");
                    if(FlipfitCustomerService.changePassword(username, oldPassword, newPassword)){
                        System.out.println("Password changed successfully!");
                    }
                    break;
                case 2:
                    System.out.println("You selected GymOwner role.");
                    if(FlipfitGymOwnerService.changePassword(username, oldPassword, newPassword)){
                        System.out.println("Password changed successfully!");
                    }
                    break;
                case 3:
                    System.out.println("You selected Admin role.");
                    if(FlipfitAdminService.changePassword(username, oldPassword, newPassword)){
                        System.out.println("Password changed successfully!");
                    }
                    break;
                default:
                    System.out.println("Invalid role choice. Please choose 1, 2, or 3.");
            }
        }
        catch (Exception e) {
            System.out.println("Please chosen a valid option");
        }
    }
}