package controller;

import entity.Visitor;

import java.util.Scanner;

public class MenuController {
        Scanner scanner = new Scanner(System.in);
        Visitor visitor;
    public void mainMenu(){
        System.out.println("Welcome to the Workpal\n1.Sign up\n2.Sign in\n0.Exit");
        int userChoice;
        try {
            userChoice = scanner.nextInt();
            do {
                switch (userChoice) {
                    case 1:
                        signUp();
                        break;
                        case 2:
                            break;
                            case 0:
                                break;
                }
            }while(userChoice != 0 && userChoice != -1);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public void signUp(){
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();
        if (username == null || username.isEmpty()) {
            System.out.println("Username cannot be empty");
            return;
        }
        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();
        if (password == null || password.isEmpty()) {
        System.out.println("Password cannot be empty");
        return;
        }
        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();
        if (email == null || email.isEmpty()) {
            System.out.println("Email cannot be empty");
            return;
        }

    }
}
