package com.flipkart.business;

import com.flipkart.bean.*;
import java.time.LocalDateTime;
import java.util.*;
import com.flipkart.dao.*;

public class FlipfitGymOwnerService implements FlipfitGymOwnerServiceInterface {

    Scanner scanner = new Scanner(System.in);
    // UserService instance to manage user-related operations
    FlipFitUserService userService = new FlipFitUserService();

    // HashMaps to store gym centers and gym owners
    public static HashMap<String, List<FlipFitGyms>> cityGymcenters = new HashMap<>();
    public static HashMap<String, FlipFitGymOwner> PendingGymOwnerMap = new HashMap<>();
    public static HashMap<String, FlipFitGymOwner> GymOwnerMap = new HashMap<>();

    private FlipFitGymOwnerDAOImplement gymOwnerDAO = new FlipFitGymOwnerDAOImplement();
    private CityDAOImplement cityDAO = new CityDAOImplement();
    private FlipFitUserDAOImplement userDAO = new FlipFitUserDAOImplement();

    public HashMap<String, List<FlipFitGyms>> getCityGymcenters() {
        return cityGymcenters;
    }

    /**
     * Edits the profile of the gym owner.
     *
     * @param gymOwner The gym owner whose profile needs to be edited.
     * @return True if the profile was successfully updated, false otherwise.
     */
    public boolean editProfile(FlipFitGymOwner gymOwner) {
        return gymOwnerDAO.updateProfile(gymOwner);
    }

    /**
     * Registers a new gym owner.
     *
     * @param name     The name of the gym owner.
     * @param email    The email of the gym owner.
     * @param phone    The phone number of the gym owner.
     * @param password The password for the gym owner account.
     * @param city     The city where the gym owner resides.
     * @param pincode  The pincode for the gym owner's address.
     * @param username The username for the gym owner account.
     * @param pancard  The PAN card number of the gym owner.
     * @param aadhar   The Aadhar number of the gym owner.
     * @param gst      The GST number of the gym owner.
     */
    public void createGymOwner(String name, String email, String phone, String password, String city, String pincode, String username, String pancard, String aadhar, String gst) {
        System.out.println("Registering Gym Owner");

        // Create a new role for the gym owner
        FlipFitRole role = new FlipFitRole(2, "GymOwner");
        String id = UUID.randomUUID().toString(); // Generate a unique ID for the gym owner

        // Create a FlipFitGymOwner instance
        FlipFitGymOwner gymOwner = new FlipFitGymOwner(id, name, email, phone, password, city, pincode, role.getRoleID(), username, pancard, aadhar, gst);

        // Store the pending gym owner
        PendingGymOwnerMap.put(id, gymOwner);

        // Create a corresponding FlipFitUser instance
        FlipFitUser user = new FlipFitUser(id, name, email, phone, password, city, pincode, role.getRoleID(), username);
        userService.addUser(user);

        // Add user and register gym owner in the database
        boolean val1 = userDAO.addUser(user);
        boolean val2 = userDAO.registerGymOwner(gymOwner);

        if (val1 && val2) {
            System.out.println("Gym Owner registered successfully");
        } else {
            System.out.println("Gym Owner creation failed");
        }
    }

    @Override
    public boolean addGymCenter(FlipFitGymOwner gymOwner, String gymName, int no_of_slots, String cityName, String pincode) {
        // Check if the city exists; if not, create it
        if (!cityDAO.cityExists(cityName)) {
            String cityId = UUID.randomUUID().toString();
            City citydao = new City(cityId, cityName.toLowerCase());
            boolean cityAdded = cityDAO.addCity(citydao);
            if (!cityAdded) {
                System.out.println("Failed to add city");
                return false;
            }
        }

        // Create a new gym center
        String gym_id = UUID.randomUUID().toString();
        List<FlipFitSlot> slots = new ArrayList<>();
        FlipFitGyms gymCenter = new FlipFitGyms(gym_id, gymName, no_of_slots, false, gymOwner.getUserID(), cityName, pincode, slots);

        // Store gym center in pending centers and approved gym owners map
        FlipfitAdminService.pendingCenters.put(gym_id, gymCenter);
        GymOwnerMap.put(gymOwner.getUserID(), gymOwner);

        // Add the gym center to the database
        if (gymOwnerDAO.addGymCenter(gymCenter)) {
            System.out.println("Gym Center registered successfully");
            return true;
        } else {
            System.out.println("Gym Owner not registered successfully");
            return false;
        }
    }

    /**
     * Searches for a gym center by name and city.
     *
     * @param name The name of the gym center.
     * @param city The city where the gym center is located.
     * @return The gym center if found, null otherwise.
     */
    public FlipFitGyms searchcitygc(String name, String city) {
        List<FlipFitGyms> gymCenters = cityGymcenters.get(city.toLowerCase());

        if (gymCenters != null) {
            for (FlipFitGyms gymCenter : gymCenters) {
                if (gymCenter.getGymName().equalsIgnoreCase(name)) {
                    return gymCenter;
                }
            }
        }

        return null; // Gym center not found
    }

    /**
     * Displays all gym centers associated with a specific gym owner.
     *
     * @param gymOwner The gym owner whose gym centers are to be displayed.
     */
    public void showGymCenters(FlipFitGymOwner gymOwner) {
        List<FlipFitGyms> gymCenters = gymOwnerDAO.getGymCenters(gymOwner.getUserID());

        // Print all gym centers
        for (FlipFitGyms gymCenter : gymCenters) {
            System.out.println("Gym Name: " + gymCenter.getGymName());
        }
    }

    /**
     * Allows the gym owner to edit slots for their gym centers.
     *
     * @param gymOwner The gym owner performing the slot edits.
     */
    public void editSlots(FlipFitGymOwner gymOwner) {
        try {
            System.out.println("Enter City: ");
            String city = scanner.nextLine();
            int c = 1;
            List<FlipFitGyms> gymCenters = gymOwnerDAO.getGymCenters(gymOwner.getUserID());

            if (gymCenters.isEmpty()) {
                System.out.println("No Gym Center found");
                return;
            }

            // Display gym centers in the specified city
            for (FlipFitGyms gc : gymCenters) {
                if (gc.getCity().equals(city)) {
                    System.out.println(c + ". Gym Name: " + gc.getGymName());
                    c++;
                }
            }

            System.out.println("Enter Gym (choose option): ");
            int gid = 0;
            while (gid == 0) {
                String userInput = scanner.nextLine();
                try {
                    gid = Integer.parseInt(userInput);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: not an integer");
                }
            }

            // Menu for adding or removing slots
            System.out.println("1. Add Slot");
            System.out.println("2. Remove Slot");
            int ch = scanner.nextInt();
            switch (ch) {
                case 1: // Adding a slot
                    if (gid > 0 && gid <= gymCenters.size()) {
                        String id = UUID.randomUUID().toString();
                        System.out.println("Enter year (yyyy): ");
                        int year = scanner.nextInt();
                        System.out.println("Enter month (mm): ");
                        int month = scanner.nextInt();
                        System.out.println("Enter date (dd): ");
                        int date = scanner.nextInt();
                        System.out.println("Enter hour according to 24 hrs clock (0-23): ");
                        int hr = scanner.nextInt();

                        if (hr > 24 || hr < 0 || month > 12 || month < 0 || date > 31 || date < 0) {
                            System.out.println("Invalid Date & Time");
                            break;
                        }

                        LocalDateTime st = LocalDateTime.of(year, month, date, hr, 0, 0);
                        System.out.println("Enter capacity of slot (Number of vacancies): ");
                        int cp = scanner.nextInt();
                        FlipFitSlot slt = new FlipFitSlot(id, gymCenters.get(gid - 1).getGymId(), st, st.plusHours(1), cp);
                        gymOwnerDAO.addSlots(gymCenters.get(gid - 1).getGymId(), slt);
                    } else {
                        System.out.println("Invalid Gym ID.");
                    }
                    break;
                case 2: // Removing a slot
                    if (gid > 0 && gid <= gymCenters.size()) {
                        System.out.println("Enter year (yyyy): ");
                        int year = scanner.nextInt();
                        System.out.println("Enter month (mm): ");
                        int month = scanner.nextInt();
                        System.out.println("Enter date (dd): ");
                        int date = scanner.nextInt();
                        System.out.println("Enter hour according to 24 hrs clock: ");
                        int hr = scanner.nextInt();
                        LocalDateTime st = LocalDateTime.of(year, month, date, hr, 0, 0);
                        gymOwnerDAO.removeSlot(gymCenters.get(gid - 1).getGymId(), st);
                    } else {
                        System.out.println("Invalid Gym ID.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong, please try again.");
        }
    }
}
