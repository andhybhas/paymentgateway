package com.api.paymentgateway.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class VaPaymentResponseDTO {

    private Long vaNUmber;
    private String customerName;
    private BigDecimal amount;

}
