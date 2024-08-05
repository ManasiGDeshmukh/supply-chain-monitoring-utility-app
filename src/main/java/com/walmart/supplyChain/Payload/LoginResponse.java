package com.walmart.supplyChain.Payload;

import lombok.Data;

@Data
public class LoginResponse {
    String message;
    Boolean status;
    int userId;

    public LoginResponse(String message, Boolean status, int userId) {
        this.message = message;
        this.status = status;
        this.userId = userId;
    }
}
