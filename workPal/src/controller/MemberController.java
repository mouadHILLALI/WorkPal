package controller;

import entity.Visitor;
import service.VisitorServices;

import java.util.Scanner;

public class MemberController {
    Scanner sc = new Scanner(System.in);
    public void memberMenu(Visitor visitor) {
        try {
            int userChoice = -1;
            System.out.println("Welcome" + " " + visitor.getUsername());
            System.out.println("Welcome to member menu\n1.Manage Your Profile\n2.Manege Coworking spaces\n0.sign out");
            do {
                userChoice = sc.nextInt();
                switch (userChoice) {
                    case 1:
                        manageProfile(visitor);
                        break;
                    case 2:
                        System.out.println("Enter Your Member ID");
                        break;
                    case 0:

                        break;
                    default:
                }
            }while (userChoice != 0 && userChoice != -1);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void manageProfile(Visitor visitor) {
        try {
            Scanner scanner = new Scanner(System.in);
            int userChoice = -1;
            System.out.println("Welcome" + " " + visitor.getUsername());
            System.out.println("Welcome to profile menu\n1.Update your address\n2.Update your phone number\n3.Update your profile picture\n5.change your password\n4.return to main menu\n0.sign out ");
            userChoice = scanner.nextInt();
            do {
                switch (userChoice) {
                    case 1:
                        System.out.println("Enter Your new address:\n");
                        break;
                    case 2:
                        System.out.println("Enter Your Member ID");
                        break;
                    case 3:
                        System.out.println("Enter Your Member ID");
                        break;
                    case 4:
                        System.out.println("Enter Your Member ID");
                    case 5:
                        System.out.println("please enter your new password\n");
                        Scanner sc = new Scanner(System.in);
                        String password = sc.nextLine();
                        String email = visitor.getEmail();
                        VisitorServices visitorService = new VisitorServices();
                        visitorService.updatePassword(email, password);
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                }
            }while (userChoice != 0 && userChoice != -1);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
