package com.alloy.serviceImpl;

import java.util.ArrayList;

import com.alloy.model.AmountRange;
import com.alloy.model.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	public static void main(String[] args) throws JsonProcessingException {
		ArrayList<Customer> list = new ArrayList<Customer>();

		Customer c = new Customer();
		
		/*list.add(new Customer("11", "Customer", "Customer"));
		list.add(new Customer("11", "Customer", "Customer"));
*/
		
		AmountRange range= new AmountRange();
		
		range.setEnd(5000);
		range.setStart(10000);
		ObjectMapper mapper = new ObjectMapper();

		System.out.println(mapper.writeValueAsString(range));

	}

}
