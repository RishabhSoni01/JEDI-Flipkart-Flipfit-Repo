/**
 *
 */
package com.flipkart.client;

import com.flipkart.bean.*;
import com.flipkart.business.*;
import com.flipkart.dao.*;
import com.flipkart.exception.GymNotFoundException;
import com.flipkart.exception.InvalidChoiceException;

import java.util.*;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
/**
 *
 */
public class FlipfitCustomerMenu {
    private FlipfitCustomerServiceInterface customerService = new FlipfitCustomerService();
    private FlipFitUserService userService = new FlipFitUserService();
    private FlipfitGymOwnerService gymOwnerService = new FlipfitGymOwnerService();
    private BookingService bookingService = new BookingService();
    private CityDAOImplement cityDAO = new CityDAOImplement();
    private Scanner scanner = new Scanner(System.in);


    public void registerCustomer(Scanner scanner) {
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

        // Create a new customer using the provided details
        String id = UUID.randomUUID().toString();
        FlipFitUser user=new FlipFitUser(id,name,email,phone,password,city,pincode,3,username);
        FlipFitUserDAOImplement userDAO=new FlipFitUserDAOImplement();
        boolean userAdded = userDAO.addUser(user);
        System.out.println("User added: " + userAdded);
        List<Booking> bookings = new ArrayList<>();
        FlipFitCustomer customer=new FlipFitCustomer(id,name,email,phone,password,city,pincode,3,username,bookings);
        boolean customerRegistered = false;
        if (userAdded) {
            customerRegistered = userDAO.registerCustomer(customer);
            System.out.println("Customer registered: " + customerRegistered);
        }

        // Log the outcome of the creation process
        if (userAdded && customerRegistered) {
            System.out.println("Customer created successfully");
        } else {
            System.out.println("Customer creation failed");
        }
    }

    public void customerMainPage (FlipFitCustomer customer) throws GymNotFoundException {
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

            switch (userChoice) {
                case 1:
                    customerService.viewProfile(customer);
                    break;
                case 2:
                    try {
                        editProfile(customer);
                    } catch (InvalidChoiceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        addbookings(customer);
                    } catch (GymNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    viewBookings(customer.getUserID());
                    break;
                case 5:
                    cancelbookings(customer.getUserID());
                    break;
                case 6:
                    changePassword(customer);
                    break;
                case 7:
                    System.out.println("Logging Out!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    public void viewBookings(String userId) {
        List<Booking> bookings = customerService.viewBookings(userId);

        if (bookings.isEmpty()) {
            System.out.println("No bookings found for user: " + userId);
        } else {
            System.out.println("Bookings for user: " + userId);
            for (Booking booking : bookings) {
                System.out.println("Booking Gym: " + booking.getGymName());
                System.out.println("Slot Time: " + booking.getSlot().getStartTime() + " - " + booking.getSlot().getEndTime());
                System.out.println();
            }
        }
    }
    public void cancelbookings(String userId) {
        List<Booking> bookings = customerService.viewBookings(userId);
        if (bookings.isEmpty()) {
            System.out.println("No bookings found!!!");
        }
        else {
            System.out.println("Bookings:\n");
            int itr=1;
            for (Booking booking : bookings) {
                System.out.println(itr + ". " + booking.getGymName() + ": " + booking.getBookingDate() + " Duration: 1hr\n");
                itr++;
            }
            System.out.println("Choose a booking you wish to cancel(enter the number): ");
            int choice = scanner.nextInt();
            Booking booking = bookings.get(choice-1);
            if(bookingService.cancelBooking(userId,booking.getSlotID())){
                System.out.println("Slot Cancelled");
            } else {
                System.out.println("Cancellation unsuccessful!!");
            }
        }
    }
    public void editProfile(FlipFitCustomer customer) throws InvalidChoiceException {
        if (customer != null) {
            boolean updating = true;
            while (updating) {
                System.out.println("Choose the field to update:");
                System.out.println("1. Name");
                System.out.println("2. Email");
                System.out.println("3. Phone");
                System.out.println("4. City");
                System.out.println("5. Pincode");
                System.out.println("6. Exit");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Enter new name:");
                        customer.setName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Enter new email:");
                        customer.setEmail(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Enter new phone:");
                        customer.setPhoneNumber(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println("Enter new city:");
                        customer.setCity(scanner.nextLine());
                        break;
                    case 5:
                        System.out.println("Enter new pincode:");
                        customer.setPincode(scanner.nextLine());
                        break;
                    case 6:
                        updating = false;
                        break;
                    default:
//                        System.out.println("Invalid choice. Please try again.");
                        throw new InvalidChoiceException("Invalid choice. Recheck");
                }
            }
//            Make an update function in DAO for customer table entry
            if(customerService.editProfile(customer)){
                System.out.println("Customer profile updated.");
            }
        } else {
            System.out.println("Customer not found.");
        }
    }
    public void addbookings(FlipFitCustomer customer) throws GymNotFoundException {
        List<City> cities = cityDAO.getAllCities();
        AtomicInteger itr = new AtomicInteger(1);
        cities.forEach(city -> {
            System.out.println(itr.getAndIncrement() + ". " + city.getCityName());
        });
        System.out.println("Enter City: ");
        String city=scanner.nextLine();
        int c=1;
        List<FlipFitGyms> gymCenters = customerService.viewGyms(city.toLowerCase());
        for(FlipFitGyms gymCenter :gymCenters){
            System.out.println(c + ". " + gymCenter.getGymName());
            c++;
        }

        System.out.println("Enter Gym Name: ");
        String gn=scanner.nextLine();
        FlipFitGyms gymCenter_sel = gymCenters.stream()
                .filter(gc -> gc.getGymName().equalsIgnoreCase(gn))
                .findFirst()
                .orElse(null);
        if(gymCenter_sel != null){
            List<FlipFitSlot> slots = gymCenter_sel.getSlot();
            if (slots.isEmpty()) {
                System.out.println("No slots available for this gym center.");
            }
            else{
                System.out.println("Available slots:");
                for (int i = 0; i < slots.size(); i++) {
                    FlipFitSlot slot = slots.get(i);
                    System.out.printf("%d. Start time: %s, End time: %s, Capacity: %d%n",
                            i + 1, slot.getStartTime(), slot.getEndTime(), slot.getSeatsAvailable());
                }

                System.out.print("Choose a slot (enter the number): ");
                int choice = scanner.nextInt();
                FlipFitSlot slot = slots.get(choice-1);
                if(bookingService.addBooking(customer.getUserID(), gymCenter_sel, slot)){
                    System.out.println("Booking successful!");
                }
                else {
                    System.out.println("Booking failed!");
                }
            }
        }
        else{
//            System.out.println("Invalid Gym Name.");
            throw new GymNotFoundException(gn);
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
