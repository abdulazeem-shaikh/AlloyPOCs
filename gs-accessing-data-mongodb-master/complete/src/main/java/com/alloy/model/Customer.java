package com.alloy.model;

import org.springframework.data.annotation.Id;

public class Customer {

	@Id
	public String id;
	public String firstName;
	public String lastName;

	public Customer(String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
