package com.quintrix.java.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.quintrix.java.customer.documents.Customer;
import com.quintrix.java.customer.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomersService{

	@Autowired 
	CustomerRepository customerRepository;
	
	@Autowired
	static RestTemplate restTemplate = new RestTemplate();
	
	//Still working
	private static final String GET_CARS = "http://localhost:8080/cars";
	private static final String GET_CAR_DETAILS_BY_ID = "http://localhost:8080/cars/{id}";
	
	/*public Customer getCustomerDetailsByName(String name) {
		Optional<Customer> customer = customerRepository.findById(name);
	}*/
	
	@Override
	public Customer addCustomer(Customer customer) {
		Customer newCustomer = customerRepository.save(customer);
		return newCustomer;
	}
}
