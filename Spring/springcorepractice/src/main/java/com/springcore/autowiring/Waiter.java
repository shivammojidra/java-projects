package com.springcore.autowiring;

public class Waiter {
	private String waiterName;

	public String getWaiterName() {
		return waiterName;
	}

	public void setWaiterName(String waiterName) {
		this.waiterName = waiterName;
	}

	public Waiter() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Waiter [waiterName=" + waiterName + "]";
	}
	
	
}
