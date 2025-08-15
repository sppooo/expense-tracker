package com.expensetracker.model;

public class User {
    private String id;
    private String username;
    private String passwordHash;

    // Constructors, getters, setters

    public User() {}

    public User(String id, String username, String passwordHash) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    // Getters and setters...
}