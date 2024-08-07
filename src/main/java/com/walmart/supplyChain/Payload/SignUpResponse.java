package com.walmart.supplyChain.Payload;

public class SignUpResponse {
    String message;
    String username;
    int userId;

    public SignUpResponse(String message, String username, int userId) {
        this.message = message;
        this.username = username;
        this.userId = userId;
    }
}
