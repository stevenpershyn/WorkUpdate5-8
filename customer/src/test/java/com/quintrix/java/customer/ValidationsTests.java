package com.quintrix.java.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class ValidationsTests {
	
	@Mock
	List<String> strList = new ArrayList<>();
	
	@Test
	public void validateEmailForAt() {
		
		assertTrue(Validations.validateEmail("Steven@steve"));
	}
	
	@Test
	public void validateEmailForNoAt() {
		
		assertFalse(Validations.validateEmail("Steven"));
	}

	@Test 
	void validateListNegativeCase() {
	    List<String> strList = new ArrayList<>();
		
		assertFalse(Validations.validList(strList));
	}
	
	@Test 
	void validateListPositiveCase() {
	    List <String> strListMock = Mockito.mock(List.class);
	    Mockito.when(strListMock.size()).thenReturn(120);
	    //System.out.println(strListMock.size());
	    //assertEquals(120, strListMock.size());
	    assertTrue(Validations.validList(strListMock));
	}
}
