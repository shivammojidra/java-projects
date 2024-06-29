package com.springcore.constructorinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/constructorinjection/ciconfig.xml");
		TnP student1 = (TnP) context.getBean("std1");
		System.out.println(student1);
	}
}
