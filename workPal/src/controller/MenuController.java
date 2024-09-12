package controller;

import entity.Visitor;
import service.VisitorServices;

import java.util.Scanner;

public class MenuController {
    public void mainMenu(){
        System.out.println("Welcome to the Workpal\n1.Sign up\n2.Sign in\n3.reset Password\n0.Exit");
        Scanner scanner = new Scanner(System.in);
        int userChoice = -1;
        do {
        try {
            userChoice = scanner.nextInt();
                switch (userChoice) {
                    case 1:
                        signUp();
                        break;
                    case 2:
                        signIn();
                        break;
                    case 3:
                      resetPassword();
                        break;
                    case 0:
                        System.out.println("Exiting. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 0 and 2.");
                        break;
                }
        }catch (RuntimeException e) {
            throw new RuntimeException(e);     }

        }while(userChoice != 0 && userChoice != -1);
    }

    public void signUp() {
        Scanner scanner = new Scanner(System.in);

        String username = "";
        String password = "";
        String email = "";

        // Prompt for username and validate
        while (true) {
            System.out.print("Enter username: ");
            username = scanner.nextLine().trim();
            if (username.isEmpty()) {
                System.out.println("Username cannot be empty. Please try again.");
            } else if (username.length() < 3) {
                System.out.println("Username must be at least 3 characters long. Please try again.");
            } else {
                break;
            }
        }

        // Prompt for password and validate
        while (true) {
            System.out.print("Enter password: ");
            password = scanner.nextLine().trim();
            if (password.isEmpty()) {
                System.out.println("Password cannot be empty. Please try again.");
            } else if (password.length() < 6) {
                System.out.println("Password must be at least 6 characters long. Please try again.");
            } else {
                break;
            }
        }

        // Prompt for email and validate
        while (true) {
            System.out.print("Enter email: ");
            email = scanner.nextLine().trim();
            if (email.isEmpty()) {
                System.out.println("Email cannot be empty. Please try again.");
            } else if (!email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
                System.out.println("Email format is invalid. Please try again.");
            } else {
                break;
            }
        }

        // Create Visitor object and use VisitorServices
        Visitor visitor = new Visitor(username, email, password, "member");
        VisitorServices visitorServices = new VisitorServices();

        try {
           Boolean flag = visitorServices.signUpService(visitor);
           if (flag) {
               System.out.println("Sign up successful.");
               MemberController memberController = new MemberController();
               memberController.memberMenu(visitor);
           }else {
               System.out.println("Sign up failed.");
           }
        } catch (Exception e) {
            System.out.println("An error occurred during signup: " + e.getMessage());
        }
    }
    public void signIn() {
        Scanner scanner = new Scanner(System.in);
        String email = "";
        String password = "";

        while (true) {
            System.out.print("Enter email: ");
            email = scanner.nextLine().trim();
            // Validate email input
            if (email.isEmpty()) {
                System.out.println("Email cannot be empty. Please try again.");
            } else if (email.length() < 3) {
                System.out.println("Email must be at least 3 characters long. Please try again.");
            } else {
                // Ask for password
                System.out.print("Enter password: ");
                password = scanner.nextLine().trim();

                // Validate password input
                if (password.isEmpty()) {
                    System.out.println("Password cannot be empty. Please try again.");
                    continue; // Go back to asking for email and password
                }

                // Authenticate user
                VisitorServices visitorServices = new VisitorServices();
                Visitor visitor = visitorServices.getVisitor(email, password);

                // Check if visitor exists and role is "member"
                if (visitor != null && visitor.getRole().equals("member")) {
                    MemberController memberController = new MemberController();
                    memberController.memberMenu(visitor);
                } else {
                    System.out.println("Invalid email or password. Please try again.");
                }
                break;
            }
        }
    }
    public void resetPassword(){
        try {
            System.out.println("Enter your email");
            Scanner scanner = new Scanner(System.in);
            String email = scanner.nextLine().trim();
            VisitorServices visitorServices = new VisitorServices();
            visitorServices.resetPassword(email);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
