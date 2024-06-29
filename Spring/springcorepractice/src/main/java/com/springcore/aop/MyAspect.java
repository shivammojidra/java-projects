package com.springcore.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.springcore.aop.services.myException;

@Aspect
@EnableAspectJAutoProxy
@Component
public class MyAspect {
	
	@Pointcut("execution(* makePayment(..))")
	public void myPointCuts() {}
	
	
	@Before("myPointCuts()") //* represents all return type allowed // Otherwise we can specify the method with particular return type
	public void performBefore(JoinPoint p) {
		
		System.out.println("Authentication Steps...." + p.getSignature());
		
		System.out.println("Payment Started...");
		
		System.out.println("*******************************");
	}
	
	@After("execution(* makePayment(..))") //this is point cut expression
	public void performAfter() {  //The whole method is advice
		System.out.println("*******************************");
		
		System.out.println("Cleaning Resources.....");
	}
	
	@AfterThrowing(pointcut = "execution(* cleanUpAfterPayment() )", throwing = "ex")
	public void performAfterThrowig(myException ex) {
		System.out.println("The Payment threw an exception"+ex);
	}
	
	
	
	
	@Around("execution (* makePayment(..))")
	public Object newPaymentAroundAdvice(ProceedingJoinPoint pj) throws Throwable {
		
		Object obj = pj.proceed();
		
		System.out.println("Executing Payment Service with other service provider.....");
		System.out.println("This is a new Payment Method.....");
		System.out.println("Debit & Credit......");
		
		return obj;
		
		
	}
	
}
