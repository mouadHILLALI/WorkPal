package service;
import entity.Member;
import repository.admin.AdminRepositroyImpl;

import java.util.LinkedList;

public class AdminServices {
    public Boolean addUser(String username, String password , String email) {
        try {
            if (username.equals("") || password.equals("") || email.equals("")) {
                return false;
            }
            AdminRepositroyImpl admin = new AdminRepositroyImpl();
            Boolean flag = admin.addUser(username, password, email);

            if (flag) {
                return true;
            }else {
                return false;
            }
        } catch (RuntimeException e) {
            throw e;
        }
    }
    public LinkedList<Member> getAllUsers() {
        LinkedList<Member> users;
        try {
            AdminRepositroyImpl admin = new AdminRepositroyImpl();
            users = admin.getUsers();
            return users;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public Boolean deleteUser(int id) {
        try {
            AdminRepositroyImpl admin = new AdminRepositroyImpl();
            Boolean flag = admin.deleteUser(id);
            if (flag) {
                return true;
            }else{
                return false;
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public Member getMember(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive.");
        }

        try {
            AdminRepositroyImpl admin = new AdminRepositroyImpl(); // Consider dependency injection for better practice
            return admin.getMember(id); // Fetch and return the Member from repository
        } catch (RuntimeException e) {
            e.printStackTrace(); // Log the exception for debugging
            // Optionally, return null or throw a custom exception based on your use case
            return null;
        }
    }
    public Boolean updateMember(int id, String username, String password) {
        try {
            AdminRepositroyImpl admin = new AdminRepositroyImpl();
            boolean flag = admin.updateMember(id, username, password);
            if (flag) {
                return true;
            } else if (username.equals("") || password.equals("")||!flag) {
                return false;
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public Boolean updateMemberRole(int id, String role) {
        try {
            AdminRepositroyImpl admin = new AdminRepositroyImpl();
            Member check = admin.getMember(id);
            if (check != null) {
            Boolean flag = admin.updateMemberRole(id , role);
            if (flag) {
                return true;
            }else{
                return false;
            }
            }else {
                return false;
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
