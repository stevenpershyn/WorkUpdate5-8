package com.quintrix.java.quintrixspring.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {

	@Id
	private Long id;
	
	private String make;
	
	private String model;
	
	private Integer year;
	
	public Car() {}
	
	public Car(Long id, String make, String model, Integer year) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
	}
	
	public Long getId() {
		return id;
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
