package com.expensetracker.service.impl;

import com.expensetracker.model.User;
import com.expensetracker.service.UserService;

import java.sql.*;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    private static final String DB_URL = "jdbc:sqlite:expense_tracker.db";

    public UserServiceImpl() {
        // Create table if not exists
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS users (" +
                    "id TEXT PRIMARY KEY," +
                    "username TEXT UNIQUE NOT NULL," +
                    "passwordHash TEXT NOT NULL" +
                    ");";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User authenticate(String username, String password) {
        // For demo purposes, password is stored as plain text; use hashing in production
        String sql = "SELECT * FROM users WHERE username=? AND passwordHash=?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password); // Replace with hash(password)
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getString("id"),
                        rs.getString("username"),
                        rs.getString("passwordHash")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean register(User user) {
        String sql = "INSERT INTO users (id, username, passwordHash) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPasswordHash());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            // Username already exists
            return false;
        }
    }

    @Override
    public User getUserById(String id) {
        String sql = "SELECT * FROM users WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getString("id"),
                        rs.getString("username"),
                        rs.getString("passwordHash")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}