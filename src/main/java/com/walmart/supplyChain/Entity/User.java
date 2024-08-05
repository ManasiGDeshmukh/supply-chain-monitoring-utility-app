package com.walmart.supplyChain.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {
        @Id
        @Column(name="userId", length = 45)
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int userId;
        @Column(name="name", length = 255)
        private String name;
        @Column(name="email", length = 255)
        private String email;
        @Column(name="password", length = 255)
        private String password;
        @Column(name="role", length = 255)
        private String role;
        @Column(name="addr", length = 255)
        private String addr;

    public User() {
        }

    public User(int userId, String name, String email, String password, String role, String addr) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.addr = addr;
    }
}
