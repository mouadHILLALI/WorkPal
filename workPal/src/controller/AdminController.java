package controller;
import configuration.EmailSender;
import entity.Member;
import entity.Visitor;
import service.AdminServices;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Scanner;

public class AdminController {
    public void adminMenu(Visitor visitor) {
        try {
            int userChoice = -1;
            System.out.println("Welcome to Admin Menu\nWelcome " + visitor.getUsername()+"\n1.Manage users\n2.Configure program settings\n3.Manage notifications params\n4.Manage permissions\n0.sign out");
            Scanner scanner = new Scanner(System.in);
            userChoice = scanner.nextInt();
            do {
            switch (userChoice){
                case 1 :
                    manageUsers(visitor);
                    break;
                case 2 :
                 break;
                case 3 :
                    break;
                case 4 :
                    manageRoles(visitor);
                    break;
                case 0 :
                    System.exit(0);
                    break;
            }
            }while (userChoice != 0);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public void manageUsers(Visitor visitor) {
        try {
            System.out.println("welcome to users management panel\n1.Add a user\n2.Modify user info\n3.Remove a user\n4.Consult users\n0.return to main menu\n");
            Scanner scanner = new Scanner(System.in);
            int userChoice = scanner.nextInt();
            do {
            switch (userChoice){
                case 1 :
                    addUser();
                    manageUsers(visitor);
                    break;
                case 2 :
                    modifyMember();
                    manageUsers(visitor);
                    break;
                case 3 :
                deleteUser();
                manageUsers(visitor);
                    break;
                case 4 :
                getUsers();
                manageUsers(visitor);
                    break;
                case 0 :
                    adminMenu(visitor);
                    break;
            }
            }while (userChoice != 0);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public void addUser(){
        try {
            String username = "";
            String password = "";
            String email = "";
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter username: ");
            username = scanner.nextLine();
            System.out.println("Enter password: ");
            password = scanner.nextLine();
            System.out.println("Enter email: ");
            email = scanner.nextLine();
            AdminServices adminServices = new AdminServices();
            Boolean flag = adminServices.addUser(username, password, email);
            if (flag) {
                System.out.println("User added successfully");
                EmailSender.sendEmail(email , "Welcome to WorkPal" , "Welcome to WorkPal here are your credentials:\n"+"Your email : " + email + "\n" + "Your password : " + password + "\n" + "Your username" + username +"\n");
            }else {
                System.out.println("User could not be added");

            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public void getUsers() {
        LinkedList<Member> users = new LinkedList<>(); // Use generics for type safety
        try {
            AdminServices adminServices = new AdminServices();
            users = adminServices.getAllUsers(); // Assuming this returns LinkedList<Member>
            System.out.println("Member ID\tMember Username\tMember Email\n");
            for (Member user : users) { // Iterate over Member objects
                System.out.println(user.getId()+"\t"+user.getUsername()+"\t"+user.getEmail()+"\n"); // Call toString() to print user details
            }
        } catch (RuntimeException e) {
            e.printStackTrace(); // Log the exception
        }
    }
    public void deleteUser(){
        try {
            System.out.println("Enter user ID:\n");
            Scanner scanner = new Scanner(System.in);
            int userID = scanner.nextInt();
            AdminServices adminServices = new AdminServices();
            Boolean flag =  adminServices.deleteUser(userID);
            if (flag) {
                System.out.println("User deleted successfully");
            }else{
                System.out.println("User could not be deleted");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public void modifyMember() {
        try {
            AdminServices adminServices = new AdminServices();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter user ID:");
            int userID = scanner.nextInt();
            scanner.nextLine(); // Consume newline character after nextInt()

            Member member = adminServices.getMember(userID);
            if (member != null) {
                System.out.println("Enter username (press Enter to keep current): ");
                String username = scanner.nextLine(); // Read username input
                System.out.println("Enter password (press Enter to skip): ");
                String password = scanner.nextLine(); // Read password input

                // Use current username if new username is not provided
                String updatedUsername = username.isEmpty() ? member.getUsername() : username;

                // Update the member details
                boolean success = adminServices.updateMember(member.getId(), updatedUsername, password);

                if (success) {
                    System.out.println("Member updated successfully.");
                    EmailSender.sendEmail(member.getEmail() , "Welcome to WorkPal" , "Welcome to WorkPal here are your credentials:\n"+"Your email : " + member.getEmail()+ "\n" + "Your password : " + password + "\n" + "Your username" + username +"\n");
                } else {
                    System.out.println("Failed to update member.");
                }
            } else {
                System.out.println("Member could not be found.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            System.out.println("An error occurred while modifying the member.");
        }
    }
    public void manageRoles(Visitor visitor) {
        Scanner scanner = new Scanner(System.in);
        AdminServices adminServices = new AdminServices();

        while (true) {
            try {
                System.out.println("Manage users roles:\n1. Make Manager\n2. Make Member\n0. Return to Main Menu");
                System.out.print("Enter your choice: ");
                int userChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (userChoice) {
                    case 1:
                        System.out.println("Enter user ID you wish to make a manager:");
                        int managerID = scanner.nextInt();
                        adminServices.updateMemberRole(managerID, "manager");
                        System.out.println("User " + managerID + " is now a manager.");
                        break;

                    case 2:
                        System.out.println("Enter user ID you wish to make a member:");
                        int memberID = scanner.nextInt();
                        adminServices.updateMemberRole(memberID, "member");
                        System.out.println("User " + memberID + " is now a member.");
                        break;

                    case 0:
                        adminMenu(visitor); // Call the admin menu
                        return; // Exit the loop and method

                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            } catch (RuntimeException e) {
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

}
