package com.api.paymentgateway.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class VaInquiryRequestDTO {

    @NotNull
    private Integer idCustomer;

    @NotNull
    private Long vaNUmber;
}
