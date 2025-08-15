package com.expensetracker.service.impl;

import com.expensetracker.model.Transaction;
import com.expensetracker.service.TransactionService;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private static final String DB_URL = "jdbc:sqlite:expense_tracker.db";

    public TransactionServiceImpl() {
        // Create table if not exists
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS transactions (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "userId TEXT NOT NULL," +
                    "amount REAL NOT NULL," +
                    "category TEXT," +
                    "date TEXT," +
                    "description TEXT," +
                    "isRecurring INTEGER" +
                    ");";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addTransaction(Transaction transaction) {
        String sql = "INSERT INTO transactions (userId, amount, category, date, description, isRecurring) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, transaction.getUserId());
            pstmt.setDouble(2, transaction.getAmount());
            pstmt.setString(3, transaction.getCategory());
            pstmt.setString(4, transaction.getDate().toString());
            pstmt.setString(5, transaction.getDescription());
            pstmt.setInt(6, transaction.isRecurring() ? 1 : 0);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        String sql = "UPDATE transactions SET amount=?, category=?, date=?, description=?, isRecurring=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, transaction.getAmount());
            pstmt.setString(2, transaction.getCategory());
            pstmt.setString(3, transaction.getDate().toString());
            pstmt.setString(4, transaction.getDescription());
            pstmt.setInt(5, transaction.isRecurring() ? 1 : 0);
            pstmt.setInt(6, transaction.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTransaction(int transactionId) {
        String sql = "DELETE FROM transactions WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, transactionId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Transaction> getTransactionsByUser(String userId) {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE userId=?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Transaction txn = new Transaction(
                        rs.getInt("id"),
                        rs.getString("userId"),
                        rs.getDouble("amount"),
                        rs.getString("category"),
                        LocalDate.parse(rs.getString("date")),
                        rs.getString("description"),
                        rs.getInt("isRecurring") == 1
                );
                transactions.add(txn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}