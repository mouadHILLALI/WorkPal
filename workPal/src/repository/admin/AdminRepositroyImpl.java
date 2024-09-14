package repository.admin;

import DAO.Admin.AdminDao;
import DAO.Admin.AdminDaoImpl;
import DAO.Visitor.VisitorDaoImpl;
import entity.Admin;
import entity.Member;

import java.util.LinkedList;

public class AdminRepositroyImpl implements AdminRepository {
    public Boolean addUser(String username, String password , String email) {
        try {
            AdminDaoImpl adminDao = new AdminDaoImpl();
            Boolean flag = adminDao.addUser(username, password, email);
            VisitorDaoImpl visitorDao = new VisitorDaoImpl();
            Boolean check = visitorDao.getVisitor(email);
            if (flag && !check) {
                return true;
            }else {
                return false;

            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public LinkedList<Member> getUsers() {
        LinkedList<Member> members;
        try {
            AdminDaoImpl adminDao = new AdminDaoImpl();
            members = adminDao.getAll();
            return members;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Boolean deleteUser(int id) {
        try {
            AdminDaoImpl adminDao = new AdminDaoImpl();
            Boolean flag = adminDao.delete(id);
            if (flag) {
                return true;
            }else {
                return false;
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Member getMember(int id) {
        try {
            AdminDaoImpl adminDao = new AdminDaoImpl();
            Member member = adminDao.getMember(id);
            return member;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public Boolean updateMember(int id , String username, String password) {
        try {
            AdminDaoImpl adminDao = new AdminDaoImpl();
            Boolean flag = adminDao.updateMember(id, username, password);
            if (flag) {
                return true;
            }else {
                return false;
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public Boolean updateMemberRole(int id , String role) {
        try {
            AdminDaoImpl adminDao = new AdminDaoImpl();
            Boolean flag = adminDao.updateMemberRole(id, role);
            if (flag) {
                return true;
            }else {
                return false;
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
