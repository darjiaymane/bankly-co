package com.m2.transactionsmanagement.services;

import com.m2.transactionsmanagement.DTO.ResponseDTO;
import com.m2.transactionsmanagement.DTO.WalletDto;
import com.m2.transactionsmanagement.models.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionService {
    ResponseDTO executeTransaction(WalletDto wallet,Transaction transaction);
    void deleteTransaction(String id);
    List<Transaction> getTransactionsByWalletId(UUID walletId);
}
