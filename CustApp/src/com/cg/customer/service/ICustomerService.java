package com.cg.customer.service;

import java.util.List;

import com.cg.customer.model.Customer;

public interface ICustomerService {

	void addDetails(Customer bean);

	Customer retrieveById(int id);

	List<Customer> retrieveDetails();

	void deleteCustomer(int custId);

	List<Integer> retrieveIds();

	Customer update(Customer cust);

	

	//void deleteDetails(Customer cust);

	//void deleteDetails(Customer bean);
}
