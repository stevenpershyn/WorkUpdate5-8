package com.quintrix.java.quintrixspring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quintrix.java.quintrixspring.models.Car;
import com.quintrix.java.quintrixspring.models.GetCarsResponse;
import com.quintrix.java.quintrixspring.services.CarsService;

@RestController
public class CarController {
	
	private static final Logger logger = LoggerFactory.getLogger(CarController.class);
	
	@Autowired
	CarsService carsService;
	
	@Autowired
	RestTemplate restTemplate;
	
    @RequestMapping(method = RequestMethod.GET, value = "/cars")
    GetCarsResponse getCars(@RequestParam(name ="make", required = false) String make) {
    	
    	return carsService.getCars(make);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/cars/{id}")
    Car getCarDetails(@PathVariable("id") Long id) {
    	
    	logger.debug("Request: Called getCarDetails Controller {}", id);
    	return carsService.getCarDetailsById(id);
    	
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/cars")
    Car addCar(@RequestBody String carStr) throws JsonMappingException, JsonProcessingException {
    	
    	System.out.println(carStr);
    	
    	ObjectMapper objectMapper = new ObjectMapper();
    	
    	Car car = objectMapper.readValue(carStr, Car.class);
    	return carsService.addCar(car);
    }
    
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("swagger-ui.html")
        	.addResourceLocations("classpath:/META-INF/resources/");

    	registry.addResourceHandler("/webjars/**")
        	.addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    
}
