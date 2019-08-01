package com.api.paymentgateway.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "acc_number")
    private Integer accNumber;
}
