package com.productbackend.paymentservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {

	private long orderId;
	private long amount;
	private String transactionNumber;
	private PaymentMode paymentMode;
}
