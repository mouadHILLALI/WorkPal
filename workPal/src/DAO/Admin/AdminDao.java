package DAO.Admin;

import DAO.DAO;

public interface AdminDao extends DAO {
    abstract Boolean addUser(String username, String password , String email);
    abstract Boolean updateMember( int id,String username , String password);
    Boolean updateMemberRole(int id, String role);
}
