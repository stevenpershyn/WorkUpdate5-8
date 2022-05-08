package com.quintrix.java.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import com.quintrix.java.customer.jaxws.client.Add;
import com.quintrix.java.customer.jaxws.client.AddResponse;
import com.quintrix.java.customer.jaxws.client.Calculator;
import com.quintrix.java.customer.jaxws.client.CalculatorSoap;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
class CustomerApplicationTests {

	static CalculatorSoap calculatorSoapProxy = null;
	
	@BeforeAll
	public static void setup() {
		Calculator calcService = new Calculator();
		calculatorSoapProxy = calcService.getCalculatorSoap();
	}
	
	@Test
	void contextLoads() {}
	
	@Test
	public void givenCalcService_whenTwoNumbersAdded_thenResultIsSum() {
		assertEquals(9, calculatorSoapProxy.add(4, 5));
	}
	
	@Test
	public void given2Strings_whenEqual_thenCorrect() {
		String a = "foo";
		String b = "FOO";
		assertThat(a, equalToIgnoringCase(b));
	}
}
