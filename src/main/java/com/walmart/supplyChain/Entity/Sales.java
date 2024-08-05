package com.walmart.supplyChain.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="sales")
public class Sales {
    @Id
    @Column(name="Id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="custId", length = 45)
    private Long custID;
    @Column(name="shopManagerID", length = 45)
    private Long shopManagerID;
    @Column(name="storeId", length = 45)
    private Long storeID;
    @Column(name="prodID", length = 45)
    private Long prodID;
    @Column(name="cost", length = 45)
    private Float cost;
}
