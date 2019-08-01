package com.api.paymentgateway.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idCustomer;

    @Column(name = "name")
    private String customerName;

    @Column(name = "email")
    private String customerEmail;
}
