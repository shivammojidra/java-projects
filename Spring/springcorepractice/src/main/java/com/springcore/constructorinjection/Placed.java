package com.springcore.constructorinjection;

public class Placed {
	int companyId;
	String companyName;
	
	@Override
	public String toString() {
		return "Placed [companyId=" + companyId + ", companyName=" + companyName + "]";
	}

	public Placed(int companyId, String companyName) {
		this.companyId = companyId;
		this.companyName = companyName;
	}
	
	
}
