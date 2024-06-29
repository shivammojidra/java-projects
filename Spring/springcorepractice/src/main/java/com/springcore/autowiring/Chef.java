package com.springcore.autowiring;

public class Chef {
	private String chefName;

	public String getChefName() {
		return chefName;
	}

	public void setChefName(String chefName) {
		this.chefName = chefName;
	}

	public Chef() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Chef [chefName=" + chefName + "]";
	}
	
	
}
