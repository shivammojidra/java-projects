package com.springcore.beanlifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Hospital{
	private String hospitalName;

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
//		System.out.println("Setter Hospital");
		this.hospitalName = hospitalName;
	}

	@Override
	public String toString() {
		return "Hospital [hospitalName=" + hospitalName + "]";
	}

//	public void afterPropertiesSet() throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("Initializing Hospital Bean");
//		
//	}
//
//	public void destroy() throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("Destroying H bean");
//	}
	
	@PostConstruct
	public void start() {
		System.out.println("Using Annotation Initialize hospital");
	}
	
	@PreDestroy
	public void end() {
		System.out.println("Using Annotation Destroying hospital");
		
	}
	
	
	
}
