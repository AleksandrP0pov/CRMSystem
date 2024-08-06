package com.example.orderservice.entity;

public enum Message {
    NOT_FOUND("Product not found"),
    NOT_ENOUGH("Product not enough");
    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
