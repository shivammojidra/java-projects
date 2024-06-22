package com.productbackend.paymentservice.constants;

public class PaymentConstants {
	
	private PaymentConstants() {
		throw new IllegalStateException("Utility Class should not be instantiated");
	}

	public static final String PAYMENT_SUCCESS = "SUCCESS";
	public static final String ERROR_NOT_FOUND = "NOT_FOUND";
	
	public static final String PAYMENT_DETAILS_NOT_FOUND_MESSAGE = "Payment Details not found With Order Id: ";
	public static final String ERROR_INTERNAL_SERVER_ERROR = "ERROR_INTERNAL_SERVER_ERROR";
	public static final String GENERIC_DESCRIPTION_NOT_FOUND = "Entity Not found with given Id. Please verify the Id at your End.";
	
	public static final String INTERNAL_SERVER_ERROR_DESCRIPTION = "An error occured while processing the request.";
}
