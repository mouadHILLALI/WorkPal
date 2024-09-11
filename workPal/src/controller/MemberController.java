package controller;

import entity.Visitor;

public class MemberController {
    public void memberMenu(Visitor visitor) {
        try {
            int userChoice = -1;
            System.out.println("Welcome" + visitor.getUsername());
            System.out.println("Welcome to member menu\n1.Manage Your Profile\n2.Manege Coworking spaces\n0.sign out");
            do {
                switch (userChoice) {
                    case 1:
                        System.out.println("Enter Your Member ID");
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
}
