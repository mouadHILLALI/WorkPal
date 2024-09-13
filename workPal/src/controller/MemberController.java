package controller;
import javax.swing.*;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;
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
            System.out.println("Welcome" + " " + visitor.getUsername() + visitor.getId());
            System.out.println("Welcome to profile menu\n1.Update your address\n2.Update your phone number\n3.Update your profile picture\n4.change your password\n5.return to main menu\n0.sign out ");
            userChoice = scanner.nextInt();
            do {
                switch (userChoice) {
                    case 1:
                        updateAddress(visitor);
                        break;
                    case 2:
                        updatePhoneNumber(visitor);
                        break;
                    case 3:
                        uploadPicture(visitor);
                        break;
                    case 4:
                        // user reset password function
                        resetPassword(visitor);
                    case 5:
                        memberMenu(visitor);
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
    public void resetPassword(Visitor visitor) {
        try {
            System.out.println("please enter your new password\n");
            Scanner sc = new Scanner(System.in);
            String password = sc.nextLine();
            String email = visitor.getEmail();
            VisitorServices visitorService = new VisitorServices();
            visitorService.updatePassword(email, password);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateAddress(Visitor visitor) {
        try {
            Scanner sc = new Scanner(System.in);
            String address;

            // Loop until a valid address is entered
            do {
                System.out.println("Please enter your new address:");
                address = sc.nextLine().trim();

                if (address.isEmpty()) {
                    System.out.println("Address cannot be empty. Please try again.");
                }

            } while (address.isEmpty()); // Repeat until a valid address is entered

            String email = visitor.getEmail();
            VisitorServices visitorService = new VisitorServices();
            Boolean isUpdated = visitorService.updateAddress(email, address);

            if (isUpdated) {
                System.out.println("Your address has been successfully updated.");
                manageProfile(visitor);
            } else {
                System.out.println("Failed to update your address.");
                manageProfile(visitor);
            }
        } catch (RuntimeException e) {
            System.out.println("An error occurred while updating the address.");
            e.printStackTrace(); // Optional: Log the stack trace for debugging
        }
    }
    public void updatePhoneNumber(Visitor visitor) {
        try{
            Scanner sc = new Scanner(System.in);
            String phone;

            // Loop until a valid address is entered

                System.out.println("Please enter your new phone number:");
                phone = sc.nextLine().trim();
            String email = visitor.getEmail();
            VisitorServices visitorService = new VisitorServices();
            Boolean isUpdated = visitorService.updatePhone(email, phone);

            if (isUpdated) {
                System.out.println("Your phone number has been successfully updated.");
                manageProfile(visitor);
            } else {
                System.out.println("Failed to update your phone number.");
                manageProfile(visitor);
            }
        } catch (RuntimeException e) {
            System.out.println("An error occurred while updating the phone number.");
            e.printStackTrace(); // Optional: Log the stack trace for debugging
        }
    }
    public void uploadPicture(Visitor visitor) {
        try {
            // Create a file chooser
            JFileChooser fileChooser = new JFileChooser();

            // Allow only files to be selected, not directories
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

            // Set a filter to allow only image files (optional)
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg", "gif");
            fileChooser.setFileFilter(filter);

            // Show the file chooser dialog
            int result = fileChooser.showOpenDialog(null);

            // Check if the user selected a file
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());

                // Here, you can implement the logic to upload/store the file path for the visitor
            } else {
                System.out.println("No file selected");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
