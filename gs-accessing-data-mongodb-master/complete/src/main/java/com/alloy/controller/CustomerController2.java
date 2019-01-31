package com.alloy.controller;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alloy.model.Customer;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClients;

@RestController
@RequestMapping("/root2")
public class CustomerController2 {

	private final static Logger logger = Logger.getLogger(CustomerController2.class);

	
	
 
	
	

	@RequestMapping("/createcustomer")
	public String  createCustomer() {
		Customer customer = new Customer();
		customer.setFirstName("delete");
		customer.setLastName("Azeem");
		customer.setLastName("12345564575");		
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