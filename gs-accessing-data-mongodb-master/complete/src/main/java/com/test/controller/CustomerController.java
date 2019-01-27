package com.test.controller;

import javax.inject.Inject;
import javax.ws.rs.Path;

import org.springframework.stereotype.Controller;

import com.test.model.Customer;
import com.test.service.CustomerService;

@Controller
@Path("/customer")
public class CustomerController {

	@Inject
	private CustomerService  customerService;
		
	@Path("/getCustomerDetailById")
	public Customer getCustomerDetailById()
	{
		return new Customer();
	}
	 
	@Path("/updateCustomerDetailById")
	public Customer updateCustomerDetailById()
	{
		return new Customer();
	}
	
	
	@Path("/createCustomer")
	public Customer createCustomer() 
	{
		return new Customer();
	}
	
	
	@Path("/deleteCustomer")
	public Customer deleteCustomer()
	{
		return new Customer();
	}
	
	
	
	
}
