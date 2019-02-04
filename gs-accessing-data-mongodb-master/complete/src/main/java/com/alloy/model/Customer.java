package com.alloy.model;

import java.util.List;

public class Customer {
	public String customerNumber;
	public String firstName;
	public String lastName;
	public double returnedAmount;

	public Customer(String customerNumber, String firstName, String lastName, double returnedAmount) {
		super();
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.returnedAmount = returnedAmount;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
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

	public double getReturnedAmount() {
		return returnedAmount;
	}

	public void setReturnedAmount(double returnedAmount) {
		this.returnedAmount = returnedAmount;
	}

	public Customer() {
		super();
	}
	
	

}
