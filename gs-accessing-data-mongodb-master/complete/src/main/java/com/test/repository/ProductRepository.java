package com.test.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.model.Customer;
import com.test.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

	public Customer findByFirstName(String firstName);

	public List<Product> findByLastName(String lastName);

}
