package com.walmart.supplyChain.Payload;

import lombok.Data;

@Data
public class LoginResponse {
    String message;
    Boolean status;
    int userId;
    String role;
    public LoginResponse(String message, Boolean status, int userId,String role) {
        this.message = message;
        this.status = status;
        this.userId = userId;
        this.role = role;
    }
}
