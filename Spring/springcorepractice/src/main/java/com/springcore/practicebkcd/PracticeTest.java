package com.springcore.practicebkcd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Cars c1 = (Cars) context.getBean("getCars");
		System.out.println(c1);
		Feeder f1 = (Feeder) context.getBean("getFeeder");
		System.out.println(f1);
		
	}

}
