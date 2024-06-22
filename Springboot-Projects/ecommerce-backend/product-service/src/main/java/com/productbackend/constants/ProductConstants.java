package com.productbackend.constants;

public class ProductConstants {
	
	private ProductConstants() {
	    throw new IllegalStateException("Utility class for constants, which shouldn't be instantiated");
	 }

	public static final String PRODUCT_NOT_FOUND_MESSAGE = "No Product Found with Id: ";
	public static final String PRODUCT_INSUFFICIENT_QUANTITY_MESSAGE = "Insufficient product quantity in the inventory. Available Quantity: ";
	public static final String PRODUCT_NOT_FOUND_DESCRIPTION = "Product Not found with given Id. Please verify the product Id at your End.";
	public static final String INSUFFICIENT_PRODUCT_QUANTITY_DESCRIPTION = "We don't have sufficient product quantity with us";
	public static final String INTERNAL_SERVER_ERROR_DESCRIPTION = "An error occured while processing the request.";
	
	
	public static final String ERROR_PRODUCT_NOT_FOUND = "NOT FOUND";
	public static final String ERROR_INSUFFICIENT_QUANTITY = "INSUFFICIENT QUANTITY";
	public static final String ERROR_INTERNAL_SERVER_ERROR = "ERROR INTERNAL SERVER ERROR";
	
}
