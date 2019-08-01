package com.api.paymentgateway.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "merchant_id")
    private Integer merchantId;

    @Column(name = "merchant_name")
    private String merchantName;

//    @Column(name = "merchant_code")
//    private String merchantCode;

}
