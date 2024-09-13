package entity;

import java.util.HashMap;

public class Visitor {
    private int id;
    private String username;
    private String email;
    private String password;
    private String role;

    // Constructor for creating a visitor with a role of "member"
    public Visitor(String username, String email, String password , String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = "member"; // Default role is "member"
    }

    // Constructor for creating a visitor with all attributes
    public Visitor(int id, String username, String email, String password, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Constructor for creating a visitor with just email and password
    public Visitor(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
