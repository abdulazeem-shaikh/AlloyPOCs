package com.alloy.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alloy.model.Customer;
import com.alloy.service.CustomerService;

@RestController
@RequestMapping("/root")
public class CustomerController {

	private final static Logger logger = Logger.getLogger(CustomerController.class);

	@Inject
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;

	}

	@RequestMapping("/createcustomer")
	@Consumes(MediaType.APPLICATION_JSON)
	public String createCustomer(@RequestBody Customer customer) {
		logger.info("inserting the new customer detail into Mongo db");
		customerService.registerCustomer(customer);
		logger.info("inserting the new customer detail into Mongo db");
		return "record is inserted successfully";
	}

	@RequestMapping("/getCustomerDetailById")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomerDetailById() {
		return customerService.getCustomerDetail("Abdul");

	}

	@Path("/updateCustomerDetailById")
	public Customer updateCustomerDetailById() {
		return null;
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
