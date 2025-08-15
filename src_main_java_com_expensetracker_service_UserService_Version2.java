package com.expensetracker.service;

import com.expensetracker.model.User;

public interface UserService {
    User authenticate(String username, String password);
    boolean register(User user);
    User getUserById(String id);
}