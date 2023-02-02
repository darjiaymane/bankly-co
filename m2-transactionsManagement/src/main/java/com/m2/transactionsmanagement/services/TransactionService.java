package com.m2.transactionsmanagement.services;

import com.m2.transactionsmanagement.models.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionService {
    List<Transaction> getAllTransactionsByUserCIN(String CIN);
    Transaction getTransactionById(Long id);
    Transaction executeTransaction(UUID walletId, Integer walletSolde,Integer amount, String type, String description);
    void deleteTransaction(Long id);
    List<Transaction> getTransactionsByWalletId(UUID walletId);
}
