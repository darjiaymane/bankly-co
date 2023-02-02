package com.m2.transactionsmanagement.services;

import com.m2.transactionsmanagement.models.Wallet;

import java.util.List;
import java.util.UUID;

public interface WalletService {
    Wallet createWallet(Long userId);
    Wallet getWalletByUserId(Long userId);
    Wallet getWalletByUuid(String uuid);
    Wallet updateWallet(UUID walletUuid, Integer solde);
    void deleteWallet(Long walletId);
    List<Wallet> getAllWallets();
}
