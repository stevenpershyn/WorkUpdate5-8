package com.quintrix.java.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.quintrix.java.customer.documents.Customer;
import com.quintrix.java.customer.jaxws.client.Calculator;
import com.quintrix.java.customer.jaxws.client.CalculatorSoap;
import com.quintrix.java.customer.repository.CustomerRepository;

@SpringBootApplication
public class CustomerApplication implements CommandLineRunner{

	//@Autowired
	//CustomerRepository customerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//List<Customer> custList = customerRepository.findAll();
		//customerRepository.deleteAll();
		
		/*Customer customer = new Customer();
		customer.setId(3L);
		customer.setActive(true);
		customer.setAge(25);
		customer.setName("Emily");
		customer.setPhone("111-111-1113");
		customer.setState("PA");
		customerRepository.save(customer);*/
		//System.out.println(custList);
		//Calculator calcService = new Calculator();
		
		//CalculatorSoap calculatorSoapProxy = calcService.getCalculatorSoap();
		
		//System.out.println(calculatorSoapProxy.add(7, 5));
		
	}

}
