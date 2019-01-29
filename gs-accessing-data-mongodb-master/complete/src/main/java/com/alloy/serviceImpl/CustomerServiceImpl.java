package com.alloy.serviceImpl;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.alloy.model.Customer;
import com.alloy.repository.CustomerRepository;
import com.alloy.service.CustomerService;

@Repository
public class CustomerServiceImpl implements CustomerService {

	@Inject
	CustomerRepository customerRepository;

	@Override
	public Customer getCustomerDetail(String id) {
 		return customerRepository.findById(id).get();
 	}

	@Override
	public boolean updateCustomerDetail(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCustomer() {
		// TODO Auto-generated method stub
		return false;
	}

}
