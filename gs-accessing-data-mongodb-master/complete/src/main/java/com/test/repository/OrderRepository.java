package com.test.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.model.Customer;
import com.test.model.Order;

public interface OrderRepository extends MongoRepository<Order, String> {

	public Order findByFirstName(String firstName);

	public List<Order> findByLastName(String lastName);

}
