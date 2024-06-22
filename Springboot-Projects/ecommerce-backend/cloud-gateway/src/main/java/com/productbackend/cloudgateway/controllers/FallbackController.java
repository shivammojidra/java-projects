package com.productbackend.cloudgateway.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productbackend.cloudgateway.constants.ApiGatewayConstants;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

	@GetMapping(value = "/orderServiceFallBack")
	public ResponseEntity<Object> orderServiceFallBack() {
		// TODO: change the response status
		return new ResponseEntity<>(ApiGatewayConstants.ORDER_SERVICE_DOWN, HttpStatus.OK);
	}
	
	@GetMapping(value = "/productServiceFallBack")
	public ResponseEntity<Object> productServiceFallBack() {
		// TODO: change the response status
		return new ResponseEntity<>(ApiGatewayConstants.PRODUCT_SERVICE_DOWN, HttpStatus.OK);
	}
	
	@GetMapping(value = "/paymentServiceFallBack")
	public ResponseEntity<Object> paymentServiceFallBack() {
		// TODO: change the response status
		return new ResponseEntity<>(ApiGatewayConstants.PAYMENT_SERVICE_DOWN, HttpStatus.OK);
	}
}
