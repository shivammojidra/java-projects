package com.springcore.standalone.collections;

import java.util.List;
import java.util.Map;

public class Market {
	private List<String> fruits;
	private Map<String, Double> price ; 

	public List<String> getFruits() {
		return fruits;
	}

	public void setFruits(List<String> fruits) {
		this.fruits = fruits;
	}

	public Map<String, Double> getPrice() {
		return price;
	}

	public void setPrice(Map<String, Double> price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Market [fruits=" + fruits + ", price=" + price + "]";
	}
	
	
	
	
}
