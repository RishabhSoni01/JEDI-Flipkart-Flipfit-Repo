package com.flipkart.business;
import com.flipkart.bean.*;
import java.time.LocalDateTime;
import java.util.*;
import com.flipkart.business.*;
import com.flipkart.dao.*;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public class FlipfitGymOwnerService implements FlipfitGymOwnerServiceInterface {

    Scanner scanner = new Scanner(System.in);
    // UserService instance to manage user-related operations
    FlipFitUserService userService = new FlipFitUserService();
    // HashMap to store gym centers by city
    public static HashMap<String, List<FlipFitGyms>> cityGymcenters = new HashMap<>();
    // HashMap to store pending gym owners
    public static HashMap<String, FlipFitGymOwner> PendingGymOwnerMap = new HashMap<>();
    // HashMap to store approved gym owners
    public static HashMap<String, FlipFitGymOwner> GymOwnerMap = new HashMap<>();
    private FlipFitGymOwnerDAOImplement gymOwnerDAO = new FlipFitGymOwnerDAOImplement();
    private CityDAOImplement cityDAO = new CityDAOImplement();
    private FlipFitUserDAOImplement userDAO = new FlipFitUserDAOImplement();

    public HashMap<String, List<FlipFitGyms>> getCityGymcenters() {
        return cityGymcenters;
    }
    public boolean editProfile(FlipFitGymOwner gymOwner) {
        return gymOwnerDAO.updateProfile(gymOwner);
    }
    public void createGymOwner(String name,String email,String phone,String password,String city,String pincode,String username,String pancard,String aadhar, String gst) {
        System.out.println("Registering Gym Owner");
        FlipFitRole role = new FlipFitRole(2, "GymOwner");
        String id= UUID.randomUUID().toString();
        List<Booking> bookings = new ArrayList<Booking>();
        FlipFitGymOwner gymOwner = new FlipFitGymOwner(id,name,email,phone,password,city,pincode,role.getRoleID(),username,pancard,aadhar,gst);

        PendingGymOwnerMap.put(id, gymOwner);
        FlipFitUser user = new FlipFitUser(id,name,email,phone,password,city,pincode,role.getRoleID(),username);
        userService.addUser(user);
        FlipFitUserDAOImplement userDAO = new FlipFitUserDAOImplement();
        boolean val1 = userDAO.addUser(user);
        boolean val2 = userDAO.registerGymOwner(gymOwner);
        if(val1 && val2){
            System.out.println("Gym Owner registered successfully");
        }
        else System.out.println("Gym Owner creation failed");
    }

    @Override
    public boolean addGymCenter(FlipFitGymOwner gymOwner, String gymName, int no_of_slots,String cityName,String pincode) {
        if (!cityDAO.cityExists(cityName)) {
            String cityId = UUID.randomUUID().toString();;
            City citydao = new City(cityId, cityName.toLowerCase());
            boolean cityAdded = cityDAO.addCity(citydao);
            if (!cityAdded) {
                System.out.println("Failed to add city");
                return false;
            }
        }
        String gym_id = UUID.randomUUID().toString();
        List<FlipFitSlot> slots=new ArrayList<>();
        FlipFitGyms gymCenter = new FlipFitGyms(gym_id,gymName,no_of_slots,false,gymOwner.getUserID(),cityName,pincode,slots);

        FlipfitAdminService.pendingCenters.put(gym_id, gymCenter);
        GymOwnerMap.put(gymOwner.getUserID(), gymOwner );

        if(gymOwnerDAO.addGymCenter(gymCenter)){
            System.out.println("Gym Center registered successfully");
            return true;
        }
        else {
            System.out.println("Gym Owner not registered successfully");
            return false;
        }
    }
    public FlipFitGyms searchcitygc(String name, String city) {
        List<FlipFitGyms> gymCenters = cityGymcenters.get(city.toLowerCase());

        if (gymCenters != null) {
            for (FlipFitGyms gymCenter : gymCenters) {
                if (gymCenter.getGymName().equalsIgnoreCase(name)) {
                    return gymCenter;
                }
            }
        }

        return null;
    }
    public void showGymCenters(FlipFitGymOwner gymOwner) {
//        GymOwner gymOwner = GymOwnerMap.get(user.getUserid());
        FlipFitGymOwnerDAOImplement gymOwnerDAO = new FlipFitGymOwnerDAOImplement();
        List<FlipFitGyms> gymCenters = gymOwnerDAO.getGymCenters(gymOwner.getUserID());
//        print all gym centers
        for (FlipFitGyms gymCenter : gymCenters) {
            System.out.println("Gym Name: " + gymCenter.getGymName());
        }
    }


    public void editSlots(FlipFitGymOwner gymOwner) {
        try{

            System.out.println("Enter City: ");
            Scanner scanner1=new Scanner(System.in);
            String city = scanner1.nextLine();
            int c = 1;
            List<FlipFitGyms> gymCenters = gymOwnerDAO.getGymCenters(gymOwner.getUserID());
            if(gymCenters.isEmpty()){
                System.out.println("No Gym Center found");
                return;
            }

//        GymOwner go = GymOwnerMap.get(user.getUserid());
            for (FlipFitGyms gc : gymCenters) {
                if (gc.getCity().equals(city)) {
                    System.out.println(c + ". Gym Name: " + gc.getGymName());
                    System.out.println(c + ". " + gc.getGymName());
                    c++;
                }
            }
            System.out.println("Enter Gym(choose option): ");
            int gid=0 ;
            while (gid == 0) {
                String userInput = scanner.nextLine();
                try {
                    gid = Integer.parseInt(userInput);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: not an integer");
                }
            }

            System.out.println("1. Add Slot");
            System.out.println("2. Remove Slot");
            int ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    if (gid>=gymCenters.size()) {
//                    GymCenter gc = searchGC(gid,gymCenters);
                        String id = UUID.randomUUID().toString();
                        System.out.println("Enter year(yyyy): ");
                        int year = scanner.nextInt();
                        System.out.println("Enter month(mm): ");
                        int month = scanner.nextInt();
                        System.out.println("Enter date(dd): ");
                        int date = scanner.nextInt();
                        System.out.println("Enter hour according to 24hrs clock(0-23): ");
                        int hr = scanner.nextInt();
                        if(hr>24 || hr<0 || month>12 || month<0 || date > 31 || date < 0){
                            System.out.println("Invalid Date & Time");
                            break;
                        }
                        LocalDateTime st = LocalDateTime.of(year, month, date, hr, 0, 0);
                        System.out.println("Enter capacity of slot(Number of vacancies): ");
                        int cp = scanner.nextInt();
                        FlipFitSlot slt = new FlipFitSlot(id, gymCenters.get(gid-1).getGymId(),st, st.plusHours(1),cp);
                        gymOwnerDAO.addSlots(gymCenters.get(gid-1).getGymId(), slt);
//                    String result = gc.addSlot(id, st, st.plusHours(1), cp);
//                    System.out.println(result);
                    } else {
                        System.out.println("Invalid Gym ID.");
                    }
                    break;
                case 2:
                    if (gid>=gymCenters.size()) {
//                    GymCenter gc = searchGC(gid, gymCenters);
                        System.out.println("Enter year(yyyy): ");
                        int year = scanner.nextInt();
                        System.out.println("Enter month(mm): ");
                        int month = scanner.nextInt();
                        System.out.println("Enter date(dd): ");
                        int date = scanner.nextInt();
                        System.out.println("Enter hour according to 24hrs clock: ");
                        int hr = scanner.nextInt();
                        LocalDateTime st = LocalDateTime.of(year, month, date, hr, 0, 0);
                        gymOwnerDAO.removeSlot(gymCenters.get(gid-1).getGymId(),st);
                    } else {
                        System.out.println("Invalid Gym ID.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }catch(Exception e){
            System.out.println("Something went wrong, please try again.");
        }
    }

    }
