package com.api.paymentgateway.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
public class VaCheckoutRequestDTO {

    @NotNull
    private String customerName;

    @NotNull
    private String customerEmail;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private String acquirerName;

    @NotNull
    private String merchantName;
}
