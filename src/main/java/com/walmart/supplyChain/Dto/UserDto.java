package com.walmart.supplyChain.Dto;

import lombok.Data;

@Data
public class UserDto {
    //UserID | Name | email | pass | role | addr
    private int userId;
    private String name;
    private String email;
    private String password;
    private String role;
    private String addr;

    public UserDto() {}

    public UserDto(int userId, String name, String email, String password, String role, String addr) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.addr = addr;
    }
}
