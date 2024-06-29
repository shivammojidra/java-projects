package com.springcore.aop.services;

import org.springframework.stereotype.Component;

@Component("payment")
public class PaymentServiceImplement implements PaymentService {

	public void makePayment(int k) {
		
		//Payment Code
		System.out.println("Amount Debited..");
		
		/*
		 * Something happening
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		
		System.out.println("Amount Credited...");
		
	}
	
	public void cleanUpAfterPayment() {
		throw new myException("Exception occured after payment......");
	}

}
