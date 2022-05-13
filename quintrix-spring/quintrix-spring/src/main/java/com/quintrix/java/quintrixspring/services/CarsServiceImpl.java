package com.quintrix.java.quintrixspring.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.quintrix.java.quintrixspring.exception.CarNotFoundException;
import com.quintrix.java.quintrixspring.models.Car;
import com.quintrix.java.quintrixspring.models.ClientCar;
import com.quintrix.java.quintrixspring.models.GetCarsResponse;
import com.quintrix.java.quintrixspring.models.agent.Agent;
import com.quintrix.java.quintrixspring.repository.CarRepository;
import com.quintrix.java.quintrixspring.restservice.AgentService;

@Service
public class CarsServiceImpl implements CarsService {

	private static final Logger logger = LoggerFactory.getLogger(CarsServiceImpl.class);
	
	@Autowired
	CarRepository carRepository;
	
	@Autowired
	AgentService agentService;
	
	//Still working on restTemplate
	@Autowired
	RestTemplate restTemplate;
	
	
	List<Car> carsList = new ArrayList<>(Arrays.asList(new Car(1L, "Ford", "SUV", 2011),
			new Car(2L, "Honda", "SUV", 2005), new Car(2L, "Honda", "Sedan", 2012), 
			new Car(3L, "Volvo", "Truck", 2015)));

	@Override
	public GetCarsResponse getCars(String make) {
		GetCarsResponse getCarsResponse = new GetCarsResponse();
		
		if (make != null) {
			getCarsResponse.setAvailableCarsList(carsList.stream().filter(c -> c.getMake().equals(make))
					.map(c -> new Car(c.getId(), c.getMake(), c.getModel(), c.getYear()))
					.collect(Collectors.toList()));
		} 
		else {
			getCarsResponse.setAvailableCarsList(carsList);
		}
		getCarsResponse.setAvailableWarranty("2 Years Warranty");
		
		List<Agent> agentsList = agentService.getAgentList();
		
		getCarsResponse.setAgentsList(agentsList);
		return getCarsResponse;
	}
	
	@Override
	public Car getCarDetailsById(Long id) {
		//Optional<Car> car = 
	    //		carsList.stream().filter(c -> c.getId().longValue() == id.longValue()).findAny();
		
		Optional<Car> car = carRepository.findById(id);
		
	    if (car.isPresent()) {
	    	return car.get();
	    } else {
	    	logger.error("How can this happen? Why is the customer calling with id = {}", id);
	    	throw new CarNotFoundException("Invalid Id", "Please use a different Id");
	    }
	}
	
	@Override
	public Car addCar(Car car) {
		//carsList.add(car);
		
		Car createdCar = carRepository.save(car);
    	
    	return createdCar;	
	}

	@Override
	public boolean deleteCarById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
}