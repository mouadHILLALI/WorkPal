package DAO.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import configuration.DatabaseConnection;

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
}
