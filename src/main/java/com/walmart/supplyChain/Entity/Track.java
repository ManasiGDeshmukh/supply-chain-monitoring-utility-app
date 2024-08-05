package com.walmart.supplyChain.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "track")
public class Track {
    @Id
    @Column(name="reqID", length = 45)
    private Long reqID;
    @Column(name="estDeliveryDate", length = 45)
    private Date estDeliveryDate;
    @Column(name="currStatus", length = 225)
    private String currStatus;
    @Column(name="fromLocation", length = 225)
    private String fromLocation;
    @Column(name="toLocation", length = 225)
    private String toLocation;
    @Column(name="comments", length = 225)
    private String comments;
}
