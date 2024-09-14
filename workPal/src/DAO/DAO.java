package DAO;
import entity.Member;
import java.util.LinkedList;
public interface DAO<T> {
    T get(int id);
    LinkedList<Member> getAll();
    Member getMember(int id);
    void add(T t);
    boolean update();
    Boolean delete( int t);
}
