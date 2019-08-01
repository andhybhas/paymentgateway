package com.api.paymentgateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Date;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class VaInquiryResponseDTO {


    private Long vaNUmber;
    private Integer idCustomer;
    private String customerName;
    private String customerEmail;
    private BigDecimal amount;
    private String transactionTime;
    private Integer idTransaction;

    private Integer idPercentage;

}
