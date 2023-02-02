package com.m2.transactionsmanagement.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.UUID;

public class Wallet implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private Integer solde;

    @NotEmpty
    @Column(nullable = false)
    private Long userId;

    @NotEmpty
    @Column(nullable = false)
    private UUID uuid = UUID.randomUUID();

    public Wallet() {
    }
    public Wallet(Long userId) {
        this.userId = userId;
        this.solde = 0;
    }
    public Wallet(Integer solde, Long userId) {
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
