package com.api.paymentgateway.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class VaAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "va_number")
    private Long vaNumber;
}
