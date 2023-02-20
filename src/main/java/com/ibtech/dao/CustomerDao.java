package com.ibtech.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibtech.model.Customer;

import com.ibtech.util.HibernateUtil;

public class CustomerDao {
	
	//save object
	public void saveCustomer(Customer customer) {
		
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			session.save(customer);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	//update object
	public void updateCustomer(Customer customer) {
		
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			session.saveOrUpdate(customer);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}	
	//delete object
	public void deleteCustomer(long id) {
		
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
	public Object getCustomerById(long id) {
		
		Customer customer = null;
		
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			customer = session.get(Customer.class, id);
			
			//commit the transaction
			transaction.commit();
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
			customers = session.createQuery("from customer").list();
			
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
