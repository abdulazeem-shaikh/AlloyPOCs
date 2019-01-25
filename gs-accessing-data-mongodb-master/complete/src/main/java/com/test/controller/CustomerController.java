package com.test.controller;

import javax.ws.rs.Path;

import org.springframework.stereotype.Controller;

import com.test.service.CustomerService;

@Controller
@Path("/customer")
public class CustomerController {

	private CustomerService  customerService;
	
}
