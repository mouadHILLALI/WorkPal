package DAO.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import configuration.DatabaseConnection;
import entity.Member;

public class AdminDaoImpl implements AdminDao {

    @Override
    public Boolean addUser(String username, String password, String email) {
        try {
            // Get a connection to the database
            DatabaseConnection dbConnection = new DatabaseConnection();
            Connection connection = dbConnection.getConnection();
            // SQL query to insert a new user
            String sql = "INSERT INTO users(username, email, password, role) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            // Set the values for the prepared statement
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, "member"); // Default role as "member", change if necessary
            // Execute the update and check if rows were affected
            int rowsAffected = preparedStatement.executeUpdate();
            // Return true if the insertion was successful
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false in case of an error
        }
    }

    @Override
    public Object get(int id) {
        return null;
    }

    @Override
    public Map<Integer, Member> getAll() {
        Map<Integer, Member> userMap = new HashMap<>();
        try {
            DatabaseConnection dbConnection = new DatabaseConnection();
            Connection connection = dbConnection.getConnection();
            String sql = "SELECT * FROM users WHERE role <> 'admin'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Member user = new Member();  // Create a User object
                userMap.put(id, user);  // Add to the map
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Collections.emptyMap();
    }


    @Override
    public void add(Object o) {

    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public void delete(Object o) {

    }
}
