package service;


import DAO.Visitor.VisitorDaoImpl;
import com.sun.org.apache.xpath.internal.operations.Bool;
import configuration.EmailSender;
import entity.Visitor;
import repository.visitor.VisitorRepositoryImpl;

public class VisitorServices {
    public boolean signUpService(Visitor visitor) {
        boolean flag = false;
        String role = "member";
        VisitorDaoImpl visitorDao = new VisitorDaoImpl();
        flag = visitorDao.getVisitor(visitor.getEmail());
        if (flag){
            System.out.print("email already exists please log in");
            return false;
        }else {
            VisitorRepositoryImpl visitorRepository = new VisitorRepositoryImpl();
            visitorRepository.addVisitor(visitor);
            return true;
        }
    }
    public Visitor getVisitor(String email, String password) {
        VisitorRepositoryImpl visitorRepository = new VisitorRepositoryImpl();
        Visitor visitor = visitorRepository.logVisitor(email);

        // Check if visitor is found
        if (visitor == null) {
            System.out.println("Visitor not found with the given email.");
            return null;
        }

        // Check if the password matches
        if (password.equals(visitor.getPassword())) {
            return visitor;
        } else {
            System.out.println("Invalid password.");
            return null;
        }
    }
    public void resetPassword(String email) {
        VisitorDaoImpl visitorDao = new VisitorDaoImpl();
        boolean flag = visitorDao.getVisitor(email);
        if (flag) {
            String pass = "testpassword";
            VisitorRepositoryImpl visitorRepository = new VisitorRepositoryImpl();
            visitorRepository.resetPassword(email, pass);
            String content = "Hello , please use this password temporarily" + pass ;
            EmailSender.sendEmail(email , "WorkPal Password reset" , content );
        }else {
            System.out.println("email not found.");
        }
    }
    public void updatePassword(String email, String password) {
        try {
            VisitorRepositoryImpl visitorRepository = new VisitorRepositoryImpl();
            boolean flag = visitorRepository.updatePassword(email, password);
            if (flag){
                System.out.println("Password updated successfully");
            }else{
                System.out.println("Password not updated");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public Boolean updateAddress(String email, String address) {
        try {
            if (email == null || address == null) {
                return false;
            }
            VisitorRepositoryImpl visitorRepository = new VisitorRepositoryImpl();
            Boolean flag = visitorRepository.updateAddress(email, address);
            if (flag){
                return flag;
            }else {
                return false;

            }
        }
        catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public Boolean updatePhone(String email, String phone) {
        try {
            if (email == null || phone == null) {
                return false;
            }
            VisitorRepositoryImpl visitorRepository = new VisitorRepositoryImpl();
            Boolean flag = visitorRepository.updatePhone(email, phone);
            if (flag){
                return flag;
            }else {
                return false;

            }
        }
        catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
