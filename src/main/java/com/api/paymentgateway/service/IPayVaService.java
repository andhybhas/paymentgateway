package com.api.paymentgateway.service;

import com.api.paymentgateway.dto.*;
import com.api.paymentgateway.util.Response;

public interface IPayVaService {

     Response<VaCheckoutResponseDTO> checkOut (VaCheckoutRequestDTO vaCheckoutRequestDTO);

     Response<VaInquiryResponseDTO> doInquiry (VaInquiryRequestDTO vaInquiryRequestDTO);

     Response<VaPaymentResponseDTO> doPayment (VaInquiryResponseDTO vaInquiryResponseDTO);

}
