package service;

import DAO.Visitor.VisitorDaoImpl;
import entity.Visitor;

public class VisitorServices {
    public void signUpService(String email, String password , String username ) {
        boolean flag = false;
        String role = "member";
        Visitor visitor = new Visitor(username , email , password , role );
        VisitorDaoImpl visitorDao = new VisitorDaoImpl();
        flag = visitorDao.getVisitor(email);
        if (flag){
            System.out.print("email already exists please log in");
            return;
        }else {
            visitorDao.createVisitor(visitor);
        }
    }
}
