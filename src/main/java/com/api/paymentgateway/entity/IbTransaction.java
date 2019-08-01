package com.api.paymentgateway.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class IbTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "acquirer_id")
    private Integer acquirerId;

    @Column(name = "merchant_id")
    private Integer merchantId;

    @Column(name = "merch_bank_account")
    private Integer merchBankAccount;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "transaction_timestamp")
    private Date transactionTime;

    @Column(name = "status")
    private Boolean status;
}
