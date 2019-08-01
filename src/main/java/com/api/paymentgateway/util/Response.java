package com.api.paymentgateway.util;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response<T> {
    private String message;
    private T data;
}
