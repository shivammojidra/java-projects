package com.productbackend.paymentservice.service;

import com.productbackend.paymentservice.dtos.PaymentDto;
import com.productbackend.paymentservice.dtos.PaymentResponseDto;

public interface PaymentService {

	Long makePayment(PaymentDto paymentDto);

	PaymentResponseDto getPaymentDetailsByOrderId(long orderId);

}
