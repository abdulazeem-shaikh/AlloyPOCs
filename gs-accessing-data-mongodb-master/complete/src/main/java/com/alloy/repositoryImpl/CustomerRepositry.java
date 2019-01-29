package com.alloy.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import com.alloy.model.Customer;
import com.alloy.repository.CustomerRepository;

@Repository
public class CustomerRepositry implements CustomerRepository {

	
	@Autowired
	 MongoTemplate mongoTemplate;
  
	public boolean save(Customer customer) {
		MongoOperations mongoOps = mongoTemplate;
		mongoOps.save(customer);
		return true;
		 
	}
 
	public Customer findByFirstName(String firstName) {		
		MongoOperations mongoOps =mongoTemplate;		
	 return mongoOps.findOne(query(where("firstName").is("test")), Customer.class);	 
	}

	/*
	 * @Override public List<Customer> findByLastName(String lastName) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 */

	@Override
	public List<Customer> findAll() {
		MongoOperations mongoOps = mongoTemplate;
		return mongoOps.findAll(Customer.class);
	}

	public Customer deleteCustomer( ) {		
		MongoOperations mongoOps =mongoTemplate;		
	 return mongoOps.findAndRemove(query(where("firstName").is("test")), Customer.class);	 
	}

	@Override
	public Customer deleteAll() {
		MongoOperations mongoOps =mongoTemplate;		
		 return mongoOps.findAndRemove(query(where("firstName").is("delete")), Customer.class);
	}
	 

}
