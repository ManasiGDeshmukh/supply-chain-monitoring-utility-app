package com.walmart.supplyChain.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product {
    @Id
    @Column(name="prodId", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int prodId;
    @Column(name="storeId", length = 45)
    private int storeId;
    @Column(name="name", length = 255)
    private String name;
    @Column(name="cost", length = 45)
    private Float cost;
    @Column(name="details", length = 255)
    private String details;
    @Column(name="availability", length = 45)
    private int availability;

    public Product() {
    }

    public Product(int storeId, String name, Float cost, String details, int availability) {
        this.storeId = storeId;
        this.name = name;
        this.cost = cost;
        this.details = details;
        this.availability = availability;
    }
}
