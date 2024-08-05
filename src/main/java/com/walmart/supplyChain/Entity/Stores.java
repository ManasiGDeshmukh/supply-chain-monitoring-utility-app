package com.walmart.supplyChain.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "stores")
public class Stores {
    @Id
    @Column(name="warehouseID", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long warehouseID;
    @Column(name="location", length = 225)
    private String location;
    @Column(name="managerID", length = 45)
    private Long managerID;
}