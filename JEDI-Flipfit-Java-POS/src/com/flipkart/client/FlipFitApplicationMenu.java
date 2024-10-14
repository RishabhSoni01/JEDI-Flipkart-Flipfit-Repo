package com.flipkart.client;
import com.flipkart.bean.*;
import com.flipkart.business.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import com.flipkart.dao.*;
import com.flipkart.exception.InvalidChoiceException;
import com.flipkart.exception.InvalidLogin;

public class FlipFitApplicationMenu{
    public static void main(String[] args) throws InvalidLogin {
        homePage();
    }
    private static FlipfitAdminServiceInterface FlipfitAdminService = new FlipfitAdminService();
    private static FlipfitCustomerServiceInterface FlipfitCustomerService = new FlipfitCustomerService();
    private static FlipfitGymOwnerServiceInterface FlipfitGymOwnerService = new FlipfitGymOwnerService();
    private static FlipFitUserService FlipFitUserService = new FlipFitUserService();
    private static FlipfitCustomerMenu customerMenu = new FlipfitCustomerMenu();
    private static FlipfitAdminMenu adminMenu = new FlipfitAdminMenu();
    private static FlipfitGymOwnerMenu gymOwnerMenu = new FlipfitGymOwnerMenu();
    static FlipFitGymOwnerDAOImplement gymOwnerDAOImpl= new FlipFitGymOwnerDAOImplement();
    static FlipFitCustomerDAOImplement customerDAOImpl= new FlipFitCustomerDAOImplement();

    private static void homePage() throws InvalidLogin {
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
                    customerMenu.registerCustomer(scanner);
                    System.out.println("Customer Registered");
                    break;
                case 3:
                    gymOwnerMenu.registerGymOwner(scanner);
                    System.out.println("Gym Owner Registered");
                    break;
                case 4:
                    System.out.println("Change Password");
                    System.out.println("Enter your Username");
                    String username = scanner.next();

                    System.out.println("Enter your Passkey");
                    String password = scanner.next();
                    FlipFitUser user=FlipFitUserService.login(username,password);
                    System.out.println("Enter your role: 1- Admin \n2. Gym Owner \n3.Customer");
                    int choice2 = scanner.nextInt();
                    switch(choice2) {
                        case 1:
                            adminMenu.changePassword(user);
                            break;
                            case 2:
                                gymOwnerMenu.changePassword(user);
                                break;
                                case 3:
                                    customerMenu.changePassword(user);
                                    break;
                                    default:
                                        System.out.println("Invalid choice");
                    }
                    break;
                case 5:
                    System.out.println("Exiting FlipFit App. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    throw new InvalidChoiceException("Invalid choice Exception generated");
            }
        }catch (InvalidLogin e) {
            throw new InvalidLogin("Invalid Login. Recheck your Username and Password");
        }
        catch(Exception e){
            System.out.println("You have entered an invalid option or there is some internal server error!");
        }
    }

    private static void login() throws InvalidLogin {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Username");
        String username = scanner.next();

        System.out.println("Enter your Passkey");
        String password = scanner.next();
        System.out.println("Please Choose : \n1: Enter 1 to login as Admin\n2: Enter 2 to login as Customer\n3: " +
                "Enter 3 to login as GymOwner");
        int role = scanner.nextInt();
        FlipFitUser user=FlipFitUserService.login(username,password);
        if(user!=null)
        {
            switch(role){
                case 1:
                    System.out.println("Welcome Admin\n");
                    adminMenu.adminMainPage(user);
                    break;
                case 2:
                    System.out.println("Welcome Customer\n");
                    FlipFitCustomer customer=customerDAOImpl.getCustomer(user);

                    customerMenu.customerMainPage(customer);
                    break;
                case 3:
                    System.out.println("Welcome Gym Owner\n");
                    FlipFitGymOwner gymOwner = gymOwnerDAOImpl.getGymOwner(user);
                    gymOwnerMenu.gymOwnerMainPage(gymOwner);
                    break;
                default:
                    System.out.println("Invalid role. Please try again.");
            }
        }
        else {
            throw new InvalidLogin("Invalid Login. Please try again.");
        }
//
    }



}

