package com.quintrix.java.quintrixspring.models;

public class ClientCar {

	private String make;
	
	private String model;
	
	private Integer year;
	
	public ClientCar() {}
	
	public ClientCar(String make, String model, Integer year) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
	}
	
	public String getMake() {
		return make;
	}
	
	public String getModel() {
		return model;
	}
	
	public Integer getYear() {
		return year;
	}
}
