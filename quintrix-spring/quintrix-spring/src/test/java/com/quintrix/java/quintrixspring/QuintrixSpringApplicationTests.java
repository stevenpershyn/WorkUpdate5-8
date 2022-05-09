package com.quintrix.java.quintrixspring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.quintrix.java.quintrixspring.models.Car;
import com.quintrix.java.quintrixspring.services.CarsService;

@SpringBootTest
class QuintrixSpringApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void mockTest() {
		CarsService carsServiceMock = Mockito.mock(CarsService.class);
		
		Car car = new Car(777L,"Ford","CRV",2005);
		Mockito.when(carsServiceMock.getCarDetailsById(1L)).thenReturn(car);
		
		assertEquals(carsServiceMock.getCarDetailsById(1L).getId(), 777L);
	}

}
