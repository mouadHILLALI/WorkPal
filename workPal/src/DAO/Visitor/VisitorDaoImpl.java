package DAO.Visitor;

import configuration.DatabaseConnection;
import entity.Visitor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class VisitorDaoImpl implements VisitorDao {
    DatabaseConnection dbConnection = new DatabaseConnection();
    Connection connection = dbConnection.getConnection();
    @Override
    public Boolean getVisitor(String email) {
        Connection connection = null;
        try {
            connection = dbConnection.getConnection();
            String sql = "SELECT * FROM users WHERE email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Returns true if a result is found, false otherwise

        } catch (SQLException e) {
            e.printStackTrace(); // Consider using a proper logging framework
            System.out.println(e.getMessage());
            return false; // Return false when an error occurs
        } finally {
            if (connection != null) {
                dbConnection.closeConnection(connection); // Ensure connection is closed
            }
        }
    }

    @Override
    public Boolean resetPassword(String email, String password) {
        Connection connection = null;
        try {
            connection = dbConnection.getConnection();

            // Correct SQL for updating the password
            String sql = "UPDATE users SET password = ? WHERE email = ?";

            // Prepare statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, password); // Set password first
            preparedStatement.setString(2, email);    // Set email second

            // Execute the update
            int rowsUpdated = preparedStatement.executeUpdate();

            // Check if any row was updated
            return rowsUpdated > 0;

        } catch (SQLException s) {
            System.out.println(s.getMessage());
            return false;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Visitor createVisitor(Visitor visitor) {
        Connection connection = null;
        try {
            connection = dbConnection.getConnection();
            String sql = "INSERT INTO users(username, email, password, role) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, visitor.getUsername());
            preparedStatement.setString(2, visitor.getEmail());
            preparedStatement.setString(3, visitor.getPassword());
            preparedStatement.setString(4, visitor.getRole());

            int rowsAffected = preparedStatement.executeUpdate(); // Use executeUpdate for INSERT

            if (rowsAffected > 0) {
                // Retrieve generated keys (ID)
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    visitor.setId(generatedKeys.getInt(1)); // Set the generated ID to the visitor object
                }
                return visitor; // Return the visitor object with the new ID
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            if (connection != null) {
                dbConnection.closeConnection(connection);
            }
        }
        return null; // Return null if the insert fails
    }


    public Visitor loginVisitor(String email) {
        Connection connection = null;
        try {
            connection = dbConnection.getConnection();
            String sql = "SELECT * FROM users WHERE email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            // If a matching user is found, populate the Visitor object
            if (resultSet.next()) {
                Visitor visitor = new Visitor(resultSet.getInt("id") ,resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getString("role"));
                return visitor;
            } else {
                return null; // Return null if no matching user is found
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        } finally {
            if (connection != null) {
                dbConnection.closeConnection(connection); // Ensure connection is closed
            }
        }
    }

    @Override
    public Visitor get(int id) {
        return null;
    }

    @Override
    public List<Visitor> getAll() {
        return Collections.emptyList();
    }

    @Override
    public void add(Visitor visitor) {

    }

    @Override
   public boolean update(){
        return false;
    }


    @Override
    public void delete(Visitor visitor) {

    }
}
