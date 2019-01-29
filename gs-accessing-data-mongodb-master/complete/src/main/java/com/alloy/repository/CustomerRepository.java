package com.alloy.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.alloy.model.Customer;

public interface CustomerRepository extends Repository<Customer, String> {

	public Customer findByFirstName(String firstName);

	public List<Customer> findAll();
	
	public boolean save(Customer customer);
	
	public Customer deleteAll();
	
	

}
