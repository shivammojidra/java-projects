package com.productbackend.orderservice.constants;

public class OrderConstants {
	
	private OrderConstants() {
		throw new IllegalStateException("Utility class should not be initiated");
	}

	public static final String ORDER_CREATED = "CREATED";
	public static final String ORDER_PLACED = "PLACED";
	public static final String PAYMENT_FAILED = "PAYMENT_FAILED";
	
	public static final String ERROR_NOT_FOUND = "NOT FOUND";
	public static final String ERROR_INSUFFICIENT_QUANTITY = "INSUFFICIENT QUANTITY";
	public static final String ERROR_INTERNAL_SERVER_ERROR = "ERROR_INTERNAL_SERVER_ERROR";
		
	public static final String ORDER_NOT_FOUND_MESSAGE = "Order not found With Order Id: ";
	public static final String INTERNAL_SERVER_ERROR_MESSAGE = "Error Occured while processing your request.";
	
	public static final String GENERIC_DESCRIPTION_NOT_FOUND = "Entity Not found with given Id. Please verify the Id at your End.";
	public static final String PRODUCT_NOT_FOUND_DESCRIPTION = "Product Not found with given Id. Please verify the product Id at your End.";
	public static final String INSUFFICIENT_PRODUCT_QUANTITY_DESCRIPTION = "We don't have sufficient product quantity with us";
	public static final String INTERNAL_SERVER_ERROR_DESCRIPTION = "An error occured while processing the request.";
}
