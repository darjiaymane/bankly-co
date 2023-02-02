package com.m2.transactionsmanagement.repositories;

import com.m2.transactionsmanagement.models.Wallet;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Wallet findByUserId(Long userId);

    Wallet findByUuid(UUID fromString);
}