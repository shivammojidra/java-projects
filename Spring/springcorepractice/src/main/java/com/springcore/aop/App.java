package com.springcore.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springcore.aop.services.PaymentService;

public class App {

	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/aop/aopconfig.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		PaymentService paymentObj = (PaymentService) context.getBean("payment");
		
		//auth, Payment started
		//Before Join point
		paymentObj.makePayment(4);
		//After Join point
		
//		paymentObj.cleanUpAfterPayment(); // Demo of after throwing....
		
	}

}
 