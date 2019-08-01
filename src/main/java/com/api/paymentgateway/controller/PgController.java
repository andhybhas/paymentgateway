package com.api.paymentgateway.controller;

import com.api.paymentgateway.dto.*;
import com.api.paymentgateway.service.Impl.PermataVAServiceImpl;
import com.api.paymentgateway.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PgController {

    @Autowired
    PermataVAServiceImpl permataVAService;

    @PostMapping(value = "checkout", produces = "application/json")
    public ResponseEntity <Response<VaCheckoutResponseDTO>> checkOut (@Validated @RequestBody VaCheckoutRequestDTO vaCheckoutRequestDTO) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(permataVAService.checkOut(vaCheckoutRequestDTO));
    }

    @PostMapping(value = "inquiry", produces = "application/json")
    public ResponseEntity <Response<VaInquiryResponseDTO>> doInquiry (@Validated @RequestBody VaInquiryRequestDTO vaInquiryRequestDTO) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(permataVAService.doInquiry(vaInquiryRequestDTO));
    }

    @PostMapping(value = "paymentva", produces = "application/json")
    public ResponseEntity<Response<VaPaymentResponseDTO>> doPayment (@Validated @RequestBody VaInquiryResponseDTO vaInquiryResponseDTO) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(permataVAService.doPayment(vaInquiryResponseDTO));
    }
}
