package com.productbackend.paymentservice.dtos;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponseDto {

	private long id;
	private long amount;
	private long orderId;
	private String paymentMode;
	private String paymentStatus;
	private Instant transactionDate;
	private String transactionNumber;
}
