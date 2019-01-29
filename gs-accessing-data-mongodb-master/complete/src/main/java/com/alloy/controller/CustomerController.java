package com.alloy.controller;

 

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alloy.model.Customer;
import com.alloy.service.CustomerService;

@RestController
@RequestMapping("/root")
public class CustomerController {

	@Inject
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;

	}

	@RequestMapping("/createcustomer")
	public Customer createCustomer() {
		Customer customer = new Customer();
		customer.setFirstName("delete");
		customer.setLastName("Azeem");
		customer.setLastName("12345564575");
		customerService.registerCustomer(customer);

		return customer;
	}

	@RequestMapping("/getCustomerDetailById")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomerDetailById() {		
		return customerService.getCustomerDetail("Abdul");
		 
	}

	@Path("/updateCustomerDetailById")
	public Customer updateCustomerDetailById() {
		return new Customer();
	}

 
	@RequestMapping("/deleteCustomer")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCustomer() {
		  customerService.deleteCustomer();
	}

	@RequestMapping("/getAllCustomer")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getAllCustomer() {		
		return customerService.getAllCustomer();		 
	}
 
}
