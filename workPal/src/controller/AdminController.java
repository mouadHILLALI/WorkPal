package controller;

import entity.Visitor;
import service.AdminServices;

import java.util.Scanner;

public class AdminController {
    public void adminMenu(Visitor visitor) {
        try {
            int userChoice = -1;
            System.out.println("Welcome to Admin Menu\nWelcome " + visitor.getUsername()+"\n1.Manage users\n2.Manage users password\n3.Configure program settings\n4.Manage notifications params\n5.Manage permissions\n0.sign out");
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
                    break;
                case 5 :
                    break;
                case 0 :
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
                    break;
                case 3 :

                    break;
                case 4 :
                    break;
                case 0 :
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
            }else {
                System.out.println("User could not be added");

            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public void getUsers(){
        try {

        }catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
