package com.cg.customer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.customer.model.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addDetails(Customer bean) {
	
		entityManager.persist(bean);
		//entityManager.flush();	
	}

	@Override
	public List<Customer> retrieveDetails() {
		// TODO Auto-generated method stub
		
		Query query = (Query) entityManager.createNamedQuery("getAllCustomers");
		@SuppressWarnings("unchecked")
		List<Customer> custList = query.getResultList();
		
		return custList;
	}

	@Override
	public Customer retrieveById(int custId){
		
		Customer customer = entityManager.find(Customer.class, custId);
	
		return customer;
		
	}

	@Override
	public void deleteCustomer(int custId) 
	{
		Query query = entityManager.createNamedQuery("deleteCustomerById");
		query.setParameter("cId", custId);
		query.executeUpdate();
	}

	@Override
	public List<Integer> retrieveIds() {
		TypedQuery<Integer> query = entityManager.createNamedQuery("getCustomerIds", Integer.class);
		List<Integer> idList = query.getResultList();
		return idList;
	}

	@Override
	public Customer update(Customer cust) {
		return entityManager.merge(cust);
}
	}

	/*
	@Override
	public Customer retrieveByMobile(Long mobile) throws CustomerException {
		// TODO Auto-generated method stub
		Customer mobList = null;
		try{
			
			String findByMobile = "SELECT cust FROM Customer cust WHERE cust.mobile=:cMobile";
			
			TypedQuery<Customer> query = entityManager.createNamedQuery(findByMobile, Customer.class);
			query.setParameter("cMobile", mobile);
			
			mobList = query.getSingleResult();
		}
		catch(Exception e){
	
			throw new CustomerException(mobile);
		}
		
		return mobList;
	}
	*/

	/*@Override
	public void deleteDetails(Customer bean) {
		// TODO Auto-generated method stub
		
		entityManager.getTransaction().begin();
		entityManager.remove(bean);
		entityManager.getTransaction().commit();
	}*/

	/*
	@Override
	public void updateDetails(Customer bean) {
		// TODO Auto-generated method stub
		
		entityManager.getTransaction().begin();
		entityManager.merge(bean);
		entityManager.getTransaction().commit();
	}
	*/
