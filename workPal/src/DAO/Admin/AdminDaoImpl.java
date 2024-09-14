package DAO.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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

    public Member getMember(int id) {
        Member member = null; // Initialize to null
        try {
            DatabaseConnection dbConnection = new DatabaseConnection();
            Connection connection = dbConnection.getConnection();
            String sql = "SELECT * FROM users WHERE id = ?"; // SQL query to select user
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                member = new Member();
                // Populate the Member object with data from the result set
                member.setId(resultSet.getInt("id"));
                member.setUsername(resultSet.getString("username"));
                member.setPassword(resultSet.getString("password"));
                // Set other fields as necessary
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception
        }
        return member; // Return the populated Member object or null if not found
    }
    @Override
    public Boolean updateMember(int id, String username, String password) {
        try {
            // Get a connection to the database
            DatabaseConnection dbConnection = new DatabaseConnection();
            Connection connection = dbConnection.getConnection();

            // SQL query to update user details
            String sql = "UPDATE users SET username = ?, password = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Set the values for the prepared statement
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, id); // Set the user id to specify which record to update

            // Execute the update and check if rows were affected
            int rowsAffected = preparedStatement.executeUpdate();

            // Return true if the update was successful
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception
            return false; // Return false if an exception occurred
        }
    }
    @Override
    public Boolean updateMemberRole(int id, String role) {
        try {
            // Get a connection to the database
            DatabaseConnection dbConnection = new DatabaseConnection();
            Connection connection = dbConnection.getConnection();

            // SQL query to update user role
            String sql = "UPDATE users SET role = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Set the values for the prepared statement
            preparedStatement.setString(1, role);
            preparedStatement.setInt(2, id);

            // Execute the update and check if rows were affected
            int rowsAffected = preparedStatement.executeUpdate();

            // Return true if the update was successful
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception
            return false; // Return false if an exception occurs
        }
    }

    @Override
    public Object get(int id) {
        return null;
    }

    @Override
    public LinkedList<Member> getAll() {
        LinkedList<Member> users = new LinkedList<>(); // Initialize LinkedList
        try {
            DatabaseConnection dbConnection = new DatabaseConnection();
            Connection connection = dbConnection.getConnection();
            String sql = "SELECT * FROM users WHERE role <> 'admin'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Member user = new Member();
                // Assuming the id field is an integer and exists in the database table
                int id = resultSet.getInt("id");
                user.setId(id);
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setId(id); // Assuming setId() method exists in Member class
                user.setUsername(resultSet.getString("username")); // Assuming there's a 'username' field
                // Populate other fields of the user object as necessary
                users.add(user); // Add the user to the LinkedList
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users; // Return the populated LinkedList
    }


    @Override
    public void add(Object o) {

    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public Boolean delete(int id) {
        try {
            DatabaseConnection dbConnection = new DatabaseConnection();
            Connection connection = dbConnection.getConnection();
            String sql = "DELETE FROM users WHERE id = ?"; // Correct SQL syntax
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // Return true if a row was deleted, otherwise false
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }
        return false; // Return false if an exception occurred
    }

}
