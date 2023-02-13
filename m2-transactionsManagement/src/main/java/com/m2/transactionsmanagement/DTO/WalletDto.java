package com.m2.transactionsmanagement.DTO;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

public class WalletDto {

    private Integer solde;
    private Long userId;
    private UUID uuid = UUID.randomUUID();

    public WalletDto() {
    }

    public WalletDto(Integer solde, Long userId) {
        this.solde = solde;
        this.userId = userId;
    }

    public Integer getSolde() {
        return solde;
    }

    public void setSolde(Integer solde) {
        this.solde = solde;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
