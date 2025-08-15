package com.expensetracker.controller;

import com.expensetracker.service.TransactionService;
import com.expensetracker.service.UserService;

public class MainController {
    private UserService userService;
    private TransactionService transactionService;

    public MainController(UserService userService, TransactionService transactionService) {
        this.userService = userService;
        this.transactionService = transactionService;
    }

    // Handler methods for UI actions
}