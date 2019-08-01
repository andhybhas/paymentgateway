package com.api.paymentgateway.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Data
@Builder
public class VaCheckoutResponseDTO {

    private String customerName;

    private String customerEmail;

    private Long vanumber;

    private BigDecimal amount;

    private String trxCreate;

    private Integer idCustomer;

}
