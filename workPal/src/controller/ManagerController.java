package controller;

import entity.Visitor;

public class ManagerController {
    public static void managerMenu(Visitor visitor) {
        try {
            System.out.println("Welcome to the managers panel" + visitor.getUsername()+"\n");
            System.out.println("Please select an option:\n");
            System.out.println("1.Manage CoWorking spaces\n");
            System.out.println("2.Manage reservations\n");
            System.out.println("3.Manage visitors\n");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
