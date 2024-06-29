package com.springcore.beanlifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/beanlifecycle/blcconfig.xml");
//		Medicine m1 = (Medicine) context.getBean("mbn");
//		System.out.println(m1);
		
		Hospital h1 = (Hospital) context.getBean("hbn1");
		System.out.println(h1);
		
		//AbstractApplicationContext 
//		context.registerShutdownHook(); //explicitly registers shutdown / destroy 
		
		
	}

}
