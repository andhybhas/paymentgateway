package com.api.paymentgateway.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class CcAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "card_name")
    private String cardName;

    @Column(name = "card_number")
    private Integer cardNumber;

    @Column(name = "cvv")
    private Integer cvv;

    @Column(name = "expiry_date")
    private Date expiryDate;
}
