package repository.admin;

import entity.Admin;

public interface AdminRepository {
    Boolean addUser(String username, String password , String email);
}
