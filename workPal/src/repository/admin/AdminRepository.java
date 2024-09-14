package repository.admin;

import entity.Admin;
import entity.Member;

import java.util.LinkedList;

public interface AdminRepository {
    Boolean addUser(String username, String password , String email);
    LinkedList<Member> getUsers();
    Boolean deleteUser(int id);
    public Member getMember(int id);
    Boolean updateMember( int id,String username, String password);
    public Boolean updateMemberRole(int id , String role);
}
