package com.springcore.practicebkcd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//// To invoke static method using SpEL
//T(class).method(parameter/s)
//ex. T(Math).sqrt(123122)

//// To invoke static Variable using SpEL
//T(class).variable
//ex. T(Integer).MAX_VALUE 

//@Component("getCars")
public class Cars {
	
	@Value("#{new java.lang.String('Honda')}")
	private String carName;
	
	@Value("#{T(Math).sqrt(2134)}")
	private double carPrice;
	
//	@Value("#{T(Integer).MAX_VALUE}")
	@Value("2022")
	private int carLaunchYear;

	
	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public double getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}

	public int getCarLaunchYear() {
		return carLaunchYear;
	}

	public void setCarLaunchYear(int carLaunchYear) {
		this.carLaunchYear = carLaunchYear;
	}

	public Cars() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cars [carName=" + carName + ", carPrice=" + carPrice + ", carLaunchYear=" + carLaunchYear + "]";
	}

	
	
}
