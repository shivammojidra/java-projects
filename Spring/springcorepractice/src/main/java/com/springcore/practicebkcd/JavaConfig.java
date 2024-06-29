package com.springcore.practicebkcd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
//@ComponentScan(basePackages = "com.springcore.practicebkcd")  //=> This is not necessary whwn we use bean annotation
public class JavaConfig {
	
	@Bean
	public Cars getCars() {
		Cars c1 = new Cars();
		
		System.out.println("Providing Cars Object");
		return c1;
	}
	
	@Bean
//	@Scope("prototype")
	public Feeder getFeeder() {
		Feeder f1 = new Feeder();

		System.out.println("Providing Feeder Object");
		return f1;
	}
}
