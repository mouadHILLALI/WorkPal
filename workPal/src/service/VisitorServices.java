package service;


import DAO.Visitor.VisitorDaoImpl;
import entity.Member;
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

}
