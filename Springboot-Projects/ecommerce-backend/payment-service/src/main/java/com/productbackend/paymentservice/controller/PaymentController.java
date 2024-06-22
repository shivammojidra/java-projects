package com.productbackend.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productbackend.paymentservice.dtos.PaymentDto;
import com.productbackend.paymentservice.service.PaymentService;


@RestController
@RequestMapping("/v1/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping(value = "")
	public ResponseEntity<Object> makePayment(@RequestBody PaymentDto paymentDto){
		return new ResponseEntity<>(paymentService.makePayment(paymentDto), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/order/{orderId}")
	public ResponseEntity<Object> getPaymentDetailsByOrderId(@PathVariable("orderId") long orderId) {
		return new ResponseEntity<>(paymentService.getPaymentDetailsByOrderId(orderId),HttpStatus.OK);
	}
}
