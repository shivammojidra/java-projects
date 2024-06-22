package com.productbackend.paymentservice.exceptions;

public class PaymentDetailsNotFoundException extends RuntimeException {

	public PaymentDetailsNotFoundException(String message) {
		super(message);
	}
}
