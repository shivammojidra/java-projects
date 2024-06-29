package com.springcore.aop.services;

public interface PaymentService {
	public void makePayment(int k);
	public void cleanUpAfterPayment();
}
