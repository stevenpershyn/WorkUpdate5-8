package com.quintrix.java.customer.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quintrix.java.customer.documents.Customer;
import com.quintrix.java.customer.repository.CustomerRepository;
import com.quintrix.java.customer.service.CustomersService;

@RestController
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	/*@Autowired
	CustomersService customersService;*/
	
	@RequestMapping(method = RequestMethod.GET, value = "/customer")
    List<Customer> getCustomer(@RequestParam(name ="name", required = false) String make) {
    	
    	return customerRepository.findAll();
    }
	
	/*@RequestMapping(method = RequestMethod.POST, value = "/customer")
	Customer addCustomer(@RequestBody String cusStr) throws JsonMappingException, JsonProcessingException {
		
		System.out.println(cusStr);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		Customer customer = objectMapper.readValue(cusStr, Customer.class);
		return customersService.addCustomer(customer);
		
		
	}*/

}
