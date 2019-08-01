package com.api.paymentgateway.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@Entity
public class VaTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "va_id")
    private Integer vaId;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "acquirer_id")
    private Integer acquirerId;

    @Column(name = "merchant_id")
    private Integer merchantId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "transaction_timestamp")
    private String transactionTime;

//    @Column(name = "status")
//    private Boolean status;
}
