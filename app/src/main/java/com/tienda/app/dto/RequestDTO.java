package com.tienda.app.dto;

public class RequestDTO<T> {
    private String messageID;
    private T data;

    // Getters y Setters
    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
