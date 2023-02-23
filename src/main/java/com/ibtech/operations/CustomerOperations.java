package com.ibtech.operations;

import java.util.List;

import com.ibtech.model.Customer;
import com.ibtech.bag.Bag;
import com.ibtech.bag.BagKey;
import com.ibtech.dao.CustomerDao;

public class CustomerOperations {

	private CustomerDao customerDao;

	public CustomerOperations() {
		this.customerDao = new CustomerDao();
	}
	
	public Bag add(Bag bag) {
		
		String name = (String) bag.getValue(BagKey.NAME);
		String surname = (String) bag.getValue(BagKey.SURNAME);
		String tckn = (String) bag.getValue(BagKey.TCKN);
		
		Customer customer = customerDao.saveCustomer(new Customer(name, surname, tckn));
		Bag customerBag = new Bag();
		
		customerBag.put(BagKey.ID, customer.getId());
		customerBag.put(BagKey.NAME, customer.getName());
		customerBag.put(BagKey.SURNAME, customer.getSurname());
		customerBag.put(BagKey.TCKN, customer.getTckn());
		
		return customerBag;

	}
	
	public Bag update(Bag bag) {
		
		int id = (int) bag.getValue(BagKey.ID);
		String name = (String) bag.getValue(BagKey.NAME);
		String surname = (String) bag.getValue(BagKey.SURNAME);
		String tckn = (String) bag.getValue(BagKey.TCKN);
		
		Customer customer = customerDao.updateCustomer(id, name, surname, tckn);
		Bag customerBag = new Bag();
		
		customerBag.put(BagKey.ID, customer.getId());
		customerBag.put(BagKey.NAME, customer.getName());
		customerBag.put(BagKey.SURNAME, customer.getSurname());
		customerBag.put(BagKey.TCKN, customer.getTckn());
		
		return customerBag;
	}
	
	public Bag delete(Bag bag) {
		
		int id = (int) bag.getValue(BagKey.ID);
		customerDao.deleteCustomer(id);
		
		Bag customerBag = new Bag();
		customerBag.put(BagKey.ID, id);
		
		return customerBag;
	}
}
