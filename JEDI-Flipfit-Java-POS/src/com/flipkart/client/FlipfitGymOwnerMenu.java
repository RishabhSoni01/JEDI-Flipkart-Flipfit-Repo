package com.flipkart.client;

import com.flipkart.bean.*;
import com.flipkart.business.*;
import com.flipkart.dao.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
public class FlipfitGymOwnerMenu {
    private FlipFitUserService userService = new FlipFitUserService();
    private FlipfitGymOwnerService gymOwnerService = new FlipfitGymOwnerService();
    private BookingService bookingService = new BookingService();
    private CityDAOImplement cityDAO = new CityDAOImplement();
    private Scanner scanner = new Scanner(System.in);

    public void registerGymOwner(Scanner scanner) {
        System.out.println("Enter your Username");
        String username = scanner.next();
        System.out.println("Enter your Password");
        String password = scanner.next();
        System.out.println("Enter your Name");
        String name = scanner.next();
        System.out.println("Enter your Phone");
        String phone = scanner.next();
        System.out.println("Enter your Email");
        String email = scanner.next();
        System.out.println("Enter your City");
        String city = scanner.next();
        System.out.println("Enter your pincode");
        String pincode = scanner.next();
        System.out.println("Enter your aadhaar details");
        String aadhaarDetails = scanner.next();
        System.out.println("Enter your pan details");
        String panDetails = scanner.next();
        System.out.println("Enter your GST details");
        String gstDetails = scanner.next();
        // Create a new customer using the provided details
        String id = UUID.randomUUID().toString();
        FlipFitUser user = new FlipFitUser(id, name, email, phone, password, city, pincode, 2, username);
        FlipFitUserDAOImplement userDAO = new FlipFitUserDAOImplement();
        boolean userAdded = userDAO.addUser(user);
        System.out.println("User added: " + userAdded);
        FlipFitGymOwner gymOwner = new FlipFitGymOwner(id, name, email, phone, password, city, pincode, 2, username, panDetails, aadhaarDetails, gstDetails);
        boolean gymOwnerRegistered = false;
        if (userAdded) {
            gymOwnerRegistered = userDAO.registerGymOwner(gymOwner);
            System.out.println("GymOwner registered: " + gymOwnerRegistered);
        }

        // Log the outcome of the creation process
        if (userAdded && gymOwnerRegistered) {
            System.out.println("GymOwner created successfully");
        } else {
            System.out.println("GymOwner creation failed");
        }
    }

    public void gymOwnerMainPage(FlipFitGymOwner gymOwner) {

        int choice = -1;
        while (choice != 6) {
            System.out.println("Gym Owner Service Menu:");
            System.out.println("1. Add Gym Center");
            System.out.println("2. View all Gym Centers");
            System.out.println("3. Edit Slots");
            System.out.println("4. Edit Profile");
            System.out.println("5. Change Password");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addGym(gymOwner);
                    break;
                    case 2:
                        gymOwnerService.showGymCenters(gymOwner);
                        break;
                        case 3:
                            gymOwnerService.editSlots(gymOwner);
                            break;
                            case 4:
                                editProfile(gymOwner);
                                break;
                                case 5:
                                    changePassword(gymOwner);
                                    break;
                                    case 6:
                                        System.out.println("Logging Out!");
                                        break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }

        }
    }
    public void addGym(FlipFitGymOwner gymOwner) {
        System.out.println("Registering Gym Center");
        System.out.println("Enter Gym Centre Name: ");
        String gymName = scanner.nextLine();
        System.out.println("Enter Gym Centre Address: ");
        String address = scanner.nextLine();
        System.out.println("Enter Gym Centre City: ");
        String city = scanner.nextLine();
        System.out.println("Enter Gym Centre Pincode: ");
        String pincode = scanner.nextLine();
        System.out.println("Enter seats available: ");
        int capacity = scanner.nextInt();
        if(gymOwnerService.addGymCenter(gymOwner, gymName, capacity, city,pincode)){
//            System.out.println("Gym Center registered successfully.");
        }
        else {
            System.out.println("Error registering Gym Center.");
        }

    }

    public void editProfile(FlipFitGymOwner gymOwner) {
        if (gymOwner != null) {
            boolean updating = true;
            while (updating) {
                System.out.println("Choose the field to update:");
                System.out.println("1. Name");
                System.out.println("2. Email");
                System.out.println("3. Phone");
                System.out.println("4. City");
                System.out.println("5. Pincode");
                System.out.println("6. Aadhar");
                System.out.println("7. Pan Details");
                System.out.println("8. GST Details");
                System.out.println("9. Exit");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Enter new name:");
                        gymOwner.setName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Enter new email:");
                        gymOwner.setEmail(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Enter new phone:");
                        gymOwner.setPhoneNumber(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println("Enter new city:");
                        gymOwner.setCity(scanner.nextLine());
                        break;
                    case 5:
                        System.out.println("Enter new pincode:");
                        gymOwner.setPincode(scanner.nextLine());
                        break;
                    case 6:
                        System.out.println("Enter new aadhar details:");
                        gymOwner.setAadhar(scanner.nextLine());
                        break;
                        case 7:
                            System.out.println("Enter new pan details:");
                            gymOwner.setPanCard(scanner.nextLine());
                            break;
                            case 8:
                                System.out.println("Enter gst details:");
                                gymOwner.setGST(scanner.nextLine());
                                break;
                    case 9:
                        updating = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
//            Make an update function in DAO for customer table entry
            if(gymOwnerService.editProfile(gymOwner)){
                System.out.println("Gym Owner profile updated.");
            }
        } else {
            System.out.println("Gym Owner not found.");
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