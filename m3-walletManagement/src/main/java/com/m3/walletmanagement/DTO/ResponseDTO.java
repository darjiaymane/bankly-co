package com.m3.walletmanagement.DTO;

import com.m3.walletmanagement.models.Wallet;

public class ResponseDTO {
    private String status;
    private String message;
    private Wallet data;

    public ResponseDTO() {
    }

    public ResponseDTO(String message, Wallet data, String status) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public ResponseDTO(String message, String status) {
        this.status = status;
        this.message = message;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Wallet data) {
        this.data = data;
    }
}
