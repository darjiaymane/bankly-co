package com.m3.walletmanagement.services.imp;

import com.m3.walletmanagement.models.Wallet;
import com.m3.walletmanagement.repositories.WalletRepository;
import com.m3.walletmanagement.services.WalletService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class WalletServiceImp implements WalletService {
    WalletRepository walletRepository;

    public WalletServiceImp(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public Wallet createWallet(Long userId) {
        return walletRepository.save(new Wallet(userId));
    }

    @Override
    public Wallet getWalletByUserId(Long userId) {
        return walletRepository.findByUserId(userId);
    }

    @Override
    public Wallet getWalletByUuid(String uuid) {
        return walletRepository.findByUuid(UUID.fromString(uuid));
    }
    @Transactional
    @Override
    public Wallet updateWallet(UUID walletUuid, Integer solde) {
        Wallet wallet = walletRepository.findByUuid(walletUuid);
        wallet.setSolde(solde);
        return wallet;
    }

    @Override
    public void deleteWallet(Long walletId) {
        walletRepository.deleteById(walletId);
    }

    @Override
    public List<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }
}
