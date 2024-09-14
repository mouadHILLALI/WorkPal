package DAO.Admin;

import DAO.DAO;

public interface AdminDao extends DAO {
    abstract Boolean addUser(String username, String password , String email);
}
