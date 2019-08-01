package com.api.paymentgateway.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Acquirer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acquirer_id")
    private Integer AcquirerId;

    @Column(name = "acquirer_name")
    private String acquirerName;

//    @Column(name = "acquirer_code")
//    private String acquirerCode;
}
