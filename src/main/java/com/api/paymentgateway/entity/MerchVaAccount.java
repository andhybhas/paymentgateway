package com.api.paymentgateway.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class MerchVaAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "va_number")
    private Integer vaNumber;

    @Column(name = "bank_name")
    private String bankName;
}
