package com.quintrix.java.quintrixspring.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.quintrix.java.quintrixspring.models.Car;
import com.quintrix.java.quintrixspring.models.GetCarsResponse;
import com.quintrix.java.quintrixspring.services.CarsService;

public class CarControllerTests {

	@Test
	void mockTest() {
		
		CarsService carsServiceMock = Mockito.mock(CarsService.class);

		
		Car car = new Car(777L,"Ford","CRV",2005);
		Mockito.when(carsServiceMock.getCarDetailsById(1L)).thenReturn(car);
		
		assertEquals(carsServiceMock.getCarDetailsById(1L).getId(), 777L);
	}
	
	@Test
	void MockControllerTest() {
		
		CarController carController = new CarController();
		CarsService carsServiceMock = Mockito.mock(CarsService.class);
		
		carController.setCarsService(carsServiceMock);
		
		Mockito.when(carsServiceMock.deleteCarById(1L)).thenReturn(true);
		
		assertNotNull(carController.deleteById(1L));
	}
	
	@Test
	void MockControllerNegativeTest() {
		
		CarController carController = new CarController();
		CarsService carsServiceMock = Mockito.mock(CarsService.class);
		
		carController.setCarsService(carsServiceMock);
		
		Mockito.when(carsServiceMock.deleteCarById(1L)).thenReturn(true);
		
		assertNull(carController.deleteById(2L));
	}
	
	@Test
	void MockControllerMvcMocTest() throws Exception {
		
		CarController carController = new CarController();
		CarsService carsServiceMock = Mockito.mock(CarsService.class);
		
		GetCarsResponse getCarsResponse = new GetCarsResponse();
		List<Car> carsList = new ArrayList<>();
		Car car = new Car(777L,"Honda","SUV",2005);
		carsList.add(car);
		getCarsResponse.setAvailableCarsList(carsList);
		carController.setCarsService(carsServiceMock);
		Mockito.when(carsServiceMock.getCars("Honda")).thenReturn(getCarsResponse);
		
		MockMvc mockMvc = standaloneSetup(carController).build();
		
		mockMvc.perform(get("/cars").param("make", "Honda"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(jsonPath("$", notNullValue()));
			//.andExpect(jsonPath("$[0].year", is(2005)));
		//carController.setCarsService(carsServiceMock);
		
		//Mockito.when(carsServiceMock.deleteCarById(1L)).thenReturn(true);
		
		//assertNull(carController.deleteById(2L));
	}
}
