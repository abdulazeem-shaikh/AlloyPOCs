package com.alloy.serviceImpl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.alloy.model.Customer;
import com.alloy.repository.CustomerRepository;
import com.alloy.service.CustomerService;

@Repository
public class CustomerServiceImpl implements CustomerService {

	@Inject
	CustomerRepository customerRepository;

	 

	@Override
	public boolean updateCustomerDetail(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerCustomer(Customer customer) {
		customerRepository.save(customer);
		return true;
	}

	@Override
	public boolean deleteCustomer() {
		customerRepository.deleteAll();		
		return false;
	}

	@Override
	public Customer getCustomerDetail(String firstName) {
		return customerRepository.findByFirstName(firstName);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

}
