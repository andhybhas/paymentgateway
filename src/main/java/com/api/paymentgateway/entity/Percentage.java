package com.api.paymentgateway.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Percentage {
    @Id
    @Column(name = "id")
    private Integer idCustomer;

    @Column(name = "merchant_id")
    private Integer merchantId;

    @Column(name = "merchant_percent")
    private BigDecimal merchantPercent;

    @Column(name = "acquirer_id")
    private Integer acquirerId;

    @Column(name = "acquirer_percent")
    private BigDecimal acquirerPercent;
}
