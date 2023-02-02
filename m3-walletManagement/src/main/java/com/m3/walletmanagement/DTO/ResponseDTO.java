package com.m2.transactionsmanagement.DTO;

public class ResponseDTO {
    private String status;
    private String message;
    private Object data;

    public ResponseDTO() {
    }

    public ResponseDTO(String message, Object data, String status) {
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

    public void setData(Object data) {
        this.data = data;
    }
}
