package com.cg.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.customer.model.Customer;
import com.cg.customer.dao.ICustomerDao;
//import com.cg.customer.exception.CustomerException;

@Service
@Transactional	//This annotation will make automatic transaction management  
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private ICustomerDao dao;

	@Override
	public void addDetails(Customer bean) {
		// TODO Auto-generated method stub
		dao.addDetails(bean);
	}

	@Override
	public List<Customer> retrieveDetails() {
		// TODO Auto-generated method stub
		return dao.retrieveDetails();
	}

	@Override
	public Customer retrieveById(int id){
		// TODO Auto-generated method stub
		return dao.retrieveById(id);
	}

	@Override
	public void deleteCustomer(int custId)
	{
		dao.deleteCustomer(custId);
	}

	@Override
	public List<Integer> retrieveIds() {
		
		return dao.retrieveIds();
	}

	@Override
	public Customer update(Customer cust) {
		
		return dao.update(cust);
	}

	/*@Override
	public Customer retrieveByMobile(Long mobile){
		// TODO Auto-generated method stub
		return dao.retrieveByMobile(mobile);
	}

	*/
	/*@Override
	public void deleteDetails(Customer bean) {
		// TODO Auto-generated method stub
		dao.deleteDetails(bean);
	}*/
/*
	@Override
	public void updateDetails(Customer bean) {
		// TODO Auto-generated method stub
		dao.updateDetails(bean);
	}*/
}
