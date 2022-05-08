package com.quintrix.java.quintrixspring.services;

import com.quintrix.java.quintrixspring.models.Car;
import com.quintrix.java.quintrixspring.models.GetCarsResponse;

public interface CarsService {

	Car getCarDetailsById(Long id);

	GetCarsResponse getCars(String make);

	Car addCar(Car car);

}
