package com.expensetracker.model;

import java.time.LocalDate;

public class Transaction {
    private int id;
    private String userId;
    private double amount;
    private String category;
    private LocalDate date;
    private String description;
    private boolean isRecurring;

    // Constructors, getters, setters

    public Transaction() {}

    public Transaction(int id, String userId, double amount, String category, LocalDate date, String description, boolean isRecurring) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
        this.isRecurring = isRecurring;
    }

    // Getters and setters...
}