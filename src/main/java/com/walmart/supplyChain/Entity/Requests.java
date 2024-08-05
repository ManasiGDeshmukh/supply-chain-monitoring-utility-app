package com.walmart.supplyChain.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "requests")
public class Requests {
    @Id
    @Column(name="reqID", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reqID;
    @Column(name="userID", length = 45)
    private Long userID;
    @Column(name="prodID", length = 45)
    private Long prodID;
    @Column(name="quantity", length = 45)
    private Integer quantity;
    @Column(name="totalCost", length = 45)
    private Float totalCost;
    @Column(name="dateOfReq", length = 45)
    private Date dateOfReq;
    @Column(name="comment", length = 225)
    private String comment;
    @Column(name="type", length = 225)
    private String type;
}