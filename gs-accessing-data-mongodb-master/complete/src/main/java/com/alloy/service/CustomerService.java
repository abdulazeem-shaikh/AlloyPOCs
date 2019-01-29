package com.alloy.service;

import com.alloy.model.Customer;

public interface CustomerService {

	public Customer getCustomerDetail(String id);
	
	public boolean updateCustomerDetail(Customer customer);
	
	public boolean registerCustomer(Customer customer);
	
	public boolean  deleteCustomer();
	
}
