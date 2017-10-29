package com.cg.customer.dao;

import java.util.List;

import com.cg.customer.model.Customer;
//import com.cg.customer.exception.CustomerException;

public interface ICustomerDao {

	void addDetails(Customer bean);

	Customer retrieveById(int id);

	List<Customer> retrieveDetails();

	void deleteCustomer(int custId);

	List<Integer> retrieveIds();

	Customer update(Customer cust);

	//void deleteDetails(Customer bean);

	/*
	Customer retrieveByMobile(Long mobile);
	void updateDetails(Customer bean);
	*/


}
