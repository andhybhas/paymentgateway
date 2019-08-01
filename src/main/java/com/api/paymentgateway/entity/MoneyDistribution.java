package com.api.paymentgateway.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class MoneyDistribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "acquirer_money")
    private BigDecimal acquirerMoney;

    @Column(name = "merchant_money")
    private BigDecimal merchantMoney;

    @Column(name = "pg_money")
    private BigDecimal pgMoney;
}
