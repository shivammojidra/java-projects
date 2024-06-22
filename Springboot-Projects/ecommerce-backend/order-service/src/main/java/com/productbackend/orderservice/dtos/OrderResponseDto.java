package com.productbackend.orderservice.dtos;

import com.productbackend.orderservice.external.response.PaymentResponseDto;
import com.productbackend.orderservice.external.response.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDto {
	
	private long id;
	private long productId;
	private long quantity;
	private long orderAmount;
	private ProductDto productDetails;
	private PaymentResponseDto paymentDetails;
}
