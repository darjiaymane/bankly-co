package com.m2.transactionsmanagement.repositories;

import com.m2.transactionsmanagement.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findAllByWalletUUID(UUID walletId);
}