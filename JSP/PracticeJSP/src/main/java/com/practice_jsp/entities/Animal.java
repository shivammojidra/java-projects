package com.practice_jsp.entities;

public class Animal {
	private String animalName;
	private String animalFood;
	
	
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public String getAnimalFood() {
		return animalFood;
	}
	public void setAnimalFood(String animalFood) {
		this.animalFood = animalFood;
	}
	

	
	@Override
	public String toString() {
		return "Animal [animalName=" + animalName + ", animalFood=" + animalFood + "]";
	}
	
	
	
	
	
}
