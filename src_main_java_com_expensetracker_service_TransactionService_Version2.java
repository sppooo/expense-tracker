package com.expensetracker.service;

import com.expensetracker.model.Transaction;
import java.util.List;

public interface TransactionService {
    void addTransaction(Transaction transaction);
    void updateTransaction(Transaction transaction);
    void deleteTransaction(int transactionId);
    List<Transaction> getTransactionsByUser(String userId);
}