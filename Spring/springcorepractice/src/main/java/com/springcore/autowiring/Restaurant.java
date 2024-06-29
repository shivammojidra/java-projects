package com.springcore.autowiring;

public class Restaurant {
	private String restaurantName;
	private Chef chef;
	private Waiter waiter;
	private Customer customer;
	
	
	public Chef getChef() {
		return chef;
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public Waiter getWaiter() {
		return waiter;
	}
	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
	
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantName=" + restaurantName + ", chef=" + chef + ", waiter=" + waiter + ", customer="
				+ customer + "]";
	}
	
	
	
	
	
	
}
