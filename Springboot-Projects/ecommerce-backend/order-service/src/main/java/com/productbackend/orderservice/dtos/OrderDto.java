package com.productbackend.orderservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
	
	private long id;
	private long productId;
	private long quantity;
	private long orderAmount;
	private PaymentMode paymentMode;
}
