package com.productbackend.orderservice.external.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.productbackend.orderservice.external.requests.PaymentDto;



@FeignClient("payment-service/v1/payment")
public interface PaymentService {

	@PostMapping(value = "")
	public ResponseEntity<Object> makePayment(@RequestBody PaymentDto paymentDto);
	
	@GetMapping(value = "/order/{orderId}")
	public ResponseEntity<Object> getPaymentDetailsByOrderId(@PathVariable("orderId") long orderId);
}
