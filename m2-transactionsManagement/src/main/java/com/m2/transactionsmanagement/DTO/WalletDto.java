package com.m2.transactionsmanagement.DTO;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

public class WalletDto {

    private Long id;
    private Integer solde;
    private Long userId;
    private UUID uuid = UUID.randomUUID();



    public WalletDto() {
    }
    public WalletDto(Long userId) {
        this.userId = userId;
        this.solde = 0;
    }
    public WalletDto(Integer solde, Long userId) {
        this.solde = solde;
        this.userId = userId;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

}
