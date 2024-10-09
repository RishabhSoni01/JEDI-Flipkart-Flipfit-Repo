package com.flipkart.client;

import com.flipkart.business.*;
import com.flipkart.bean.*;

import java.util.*;

public class FlipfitAdminMenu {
    Scanner scanner = new Scanner(System.in);
    FlipfitAdminService gymOwnerService = new FlipfitAdminService();

    public void adminMainPage() {
        int userChoice = -1;

        // Loop until the customer chooses to exit
        while (userChoice!=10) {
            // Display customer menu options
            System.out.println("Admin Menu:");
            System.out.println("1. View Pending Gyms");
            System.out.println("2. View Pending Gym Owners");
            System.out.println("3. Approve gyms request");
            System.out.println("4. Approve gym owners request");
            System.out.println("5. Delete gym request");
            System.out.println("6. Delete gym owner request");
            System.out.println("7. View all gyms");
            System.out.println("8. View all gym owners");
            System.out.println("9. Change password");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            userChoice = scanner.nextInt();
            scanner.nextLine();
        }
    }
}
