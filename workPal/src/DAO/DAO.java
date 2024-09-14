package DAO;

import java.util.Map;

public interface DAO<T> {
    T get(int id);
    Map< T,T> getAll();
    void add(T t);
    boolean update();
    void delete(T t);
}
