package com.m2.transactionsmanagement.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID walletUUID;
    private String type;
    private Integer amount;
    private String description;
    private Date date;

    public Transaction() {
    }

    public Transaction(UUID walletUUID, String type, Integer amount, String description, Date date) {
        this.walletUUID = walletUUID;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public Transaction(UUID walletId, String type, Integer amount, String description) {
        this.walletUUID = walletId;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getWalletUuid() {
        return walletUUID;
    }

    public void setWalletId(UUID walletUUID) {
        this.walletUUID = walletUUID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", walletUUID=" + walletUUID +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
