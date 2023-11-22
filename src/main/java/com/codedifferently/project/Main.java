package com.codedifferently.project;

import java.util.Scanner;

public class Main {

    private static UserMgr userMgr = new UserMgr();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    searchUser();
                    break;
                // Add cases for other operations
                case 9:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Select an operation:");
        System.out.println("1 - Add User");
        System.out.println("2 - Search User");
        // Add options for other operations
        System.out.println("9 - Exit");
    }

    private static void addUser() {
        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last Name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter Cipher Code:");
        int cipherCode = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        User user = new User(firstName, lastName, cipherCode);
        boolean success = userMgr.addUser(user);
        if (success) {
            System.out.println("User added successfully.");
        } else {
            System.out.println("User already exists.");
        }
    }

    private static void searchUser() {
        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last Name:");
        String lastName = scanner.nextLine();

        try {
            User user = userMgr.search(firstName, lastName);
            System.out.println("User Found: " + user);
        } catch (Exception e) {
            System.out.println("User not found.");
        }
    }

    // Methods for other operations (update user, encode/decode messages, etc.)

}
