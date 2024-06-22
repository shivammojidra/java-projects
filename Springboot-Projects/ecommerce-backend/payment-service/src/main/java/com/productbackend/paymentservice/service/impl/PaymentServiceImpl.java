package com.productbackend.paymentservice.service.impl;

import java.time.Instant;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productbackend.paymentservice.constants.PaymentConstants;
import com.productbackend.paymentservice.dtos.PaymentDto;
import com.productbackend.paymentservice.dtos.PaymentResponseDto;
import com.productbackend.paymentservice.entity.PaymentDetails;
import com.productbackend.paymentservice.exceptions.PaymentDetailsNotFoundException;
import com.productbackend.paymentservice.repository.PaymentRepository;
import com.productbackend.paymentservice.service.PaymentService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public Long makePayment(PaymentDto paymentDto) {
		log.info("Saving payment details {}", paymentDto);
		
		PaymentDetails paymentDetails = PaymentDetails.builder()
				.orderId(paymentDto.getOrderId())
				.transactionNumber(paymentDto.getTransactionNumber())
				.transactionDate(Instant.now())
				.paymentMode(paymentDto.getPaymentMode().name())
				.amount(paymentDto.getAmount())
				.paymentStatus(PaymentConstants.PAYMENT_SUCCESS)
				.build();
		
		paymentRepository.save(paymentDetails);
		
		log.info("Payment Details Saved with Payment Id {}", paymentDetails.getId());
		return paymentDetails.getId();
	}

	@Override
	public PaymentResponseDto getPaymentDetailsByOrderId(long orderId) {
		log.info("Getting payment details by Order Id: {}", orderId);
		PaymentDetails paymentDetailsEntity = paymentRepository.findByOrderId(orderId).orElseThrow(() -> new PaymentDetailsNotFoundException(PaymentConstants.PAYMENT_DETAILS_NOT_FOUND_MESSAGE  + orderId));
		
		PaymentResponseDto paymentResponseDto = PaymentResponseDto.builder().build();
		BeanUtils.copyProperties(paymentDetailsEntity, paymentResponseDto);
		
		return paymentResponseDto;
	}

}
