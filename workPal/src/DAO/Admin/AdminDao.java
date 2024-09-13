package DAO.Admin;

public interface AdminDao {
    abstract Boolean addUser(String username, String password , String email);
}
