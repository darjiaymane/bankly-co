package com.m3.walletmanagement.services;

import com.m3.walletmanagement.models.Wallet;

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
