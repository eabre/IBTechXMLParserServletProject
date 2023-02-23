package com.ibtech.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibtech.model.Customer;

import com.ibtech.util.HibernateUtil;

public class CustomerDao {
	
	//save object
	public Customer saveCustomer(Customer customer) {
		
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			session.save(customer);
			return customer;
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		return null;
		
	}
	//update object
	public Customer updateCustomer(int customerId, String name, String surname, String tckn) {
		
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			Customer customer = (Customer) session.get(Customer.class, customerId);
			customer.setName(name);
			customer.setSurname(surname);
			customer.setTckn(tckn);			
			//save object
			session.saveOrUpdate(customer);
			
			//Commit olmadan çalışmıyor
			transaction.commit();
			
			return customer;
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		return null;

		
	}	
	//delete object
	public void deleteCustomer(int id) {
		
		Customer customer = null;
		
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//delete object
			customer = session.get(Customer.class, id);
			session.delete(customer);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}	

	//read object
	public Customer getCustomerById(int id) {
		
		Customer customer = null;
		
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			customer = session.get(Customer.class, id);
			
			//commit the transaction
			//transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
		return customer;
		
	}
	
	//read all Customers
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers() {
		
		List<Customer> customers = null;
		
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//get customers
			customers = session.createCriteria(Customer.class).list();
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}	
		return customers;
	}
	
}
