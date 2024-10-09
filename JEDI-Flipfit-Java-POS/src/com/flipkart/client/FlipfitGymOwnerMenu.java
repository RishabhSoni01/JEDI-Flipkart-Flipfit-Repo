package com.flipkart.client;

import com.flipkart.business.*;
import com.flipkart.bean.*;

import java.util.*;

public class FlipfitGymOwnerMenu {

    public void gymOwnerMainPage() {
        Scanner scanner = new Scanner(System.in);
        FlipfitGymOwnerService gymOwnerService = new FlipfitGymOwnerService();
        int choice=-1;
        while (choice!=5) {
            System.out.println("Gym Owner Service Menu:");
            System.out.println("1. Add Gym Center");
            System.out.println("2. Edit Slots");
            System.out.println("3. Edit Profile");
            System.out.println("4. Change Password");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

        }
    }
}