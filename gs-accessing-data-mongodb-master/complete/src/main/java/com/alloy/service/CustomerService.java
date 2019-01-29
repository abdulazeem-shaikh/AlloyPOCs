package com.alloy.service;

import java.util.List;

import com.alloy.model.Customer;

public interface CustomerService {

	public Customer getCustomerDetail(String id);
	
	public List<Customer> getAllCustomer();
	
	public boolean updateCustomerDetail(Customer customer);
	
	public boolean registerCustomer(Customer customer);
	
	public boolean  deleteCustomer();
	
	
	
	
}
