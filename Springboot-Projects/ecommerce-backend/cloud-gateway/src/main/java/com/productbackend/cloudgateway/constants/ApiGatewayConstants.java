package com.productbackend.cloudgateway.constants;

public class ApiGatewayConstants {

	private ApiGatewayConstants() {
		throw new IllegalStateException("Utility Class Shouldn't be instantiated");
	}
	
	public static final String ORDER_SERVICE_DOWN = "Order Service is down";
	public static final String PRODUCT_SERVICE_DOWN = "Product Service is down";
	public static final String PAYMENT_SERVICE_DOWN = "Payment Service is down";
}
