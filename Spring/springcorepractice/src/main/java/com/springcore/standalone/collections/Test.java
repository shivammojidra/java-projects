package com.springcore.standalone.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/standalone/collections/standaloneconfig.xml");
		
		Market m1 = (Market) context.getBean("market1");
		System.out.println(m1.getFruits());
		System.out.println(m1.getPrice());
		System.out.println(m1.getFruits().getClass().getName());
		System.out.println(m1.getPrice().getClass().getName());
	}

}
