package com.expensetracker.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    // Change the path if you want a different location or use connection string for MySQL/PostgreSQL
    private static final String SQLITE_URL = "jdbc:sqlite:expense_tracker.db";

    static {
        try {
            // Load the SQLite JDBC driver (not always required, but good practice)
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load SQLite JDBC driver", e);
        }
    }

    /**
     * Get a connection to the SQLite database.
     * @return Connection object
     * @throws SQLException if connection fails
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(SQLITE_URL);
    }

    // Example method for testing connection (optional)
    public static boolean testConnection() {
        try (Connection conn = getConnection()) {
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
}