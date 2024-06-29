package com.springcore.practicebkcd;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Feeder {
	
	
	private List<Cars> newCars;

	public List<Cars> getNewCars() {
		return newCars;
	}

	public void setNewCars(List<Cars> newCars) {
		this.newCars = newCars;
	}

	public Feeder() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Feeder [newCars=" + newCars + "]";
	}
	
	
}
