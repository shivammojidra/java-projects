package com.springcore.beanlifecycle;

public class Medicine {
	private double medicinePrice;
	private String medicineName;
	
	
	public double getMedicinePrice() {
		return medicinePrice;
	}
	public void setMedicinePrice(double medicinePrice) {
		System.out.println("Setter: Med price");
		this.medicinePrice = medicinePrice;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Medicine [medicinePrice=" + medicinePrice + ", medicineName=" + medicineName + "]";
	}
	
	
	public void init() {
		System.out.println("Executing init method");
	}
	
	public void destroy() {
		System.out.println("Executing destroy method");
	}
}
