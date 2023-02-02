package com.m3.walletmanagement.repositories;

import com.m3.walletmanagement.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Wallet findByUserId(Long userId);

    Wallet findByUuid(UUID fromString);
}