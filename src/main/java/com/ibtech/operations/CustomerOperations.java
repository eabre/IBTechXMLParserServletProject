package com.ibtech.operations;

import java.util.List;

import com.ibtech.model.Customer;

public class CustomerOperations {

	public void add(List<Customer> customerList, Customer customer) {
		
		customerList.add(customer);
	}
	
	public void update(List<Customer> customerList, Customer customer, int index) {
		
		customerList.set(index, customer);
	}
	
	public void delete(List<Customer> customerList, int index) {
		
		customerList.remove(index);
	}
}
