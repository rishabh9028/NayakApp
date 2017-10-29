package com.cg.customer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Customer")
/*@NamedQueries({@NamedQuery(name = "getAllCustomers", query = "SELECT cust FROM Customer cust"),
(name = "deleteCustomerById"  query = "DELETE FROM Customer cust WHERE cust.custId=:cId"), 
(name = "getCustomerIds"  query = "SELECT custId FROM Customer cust")}) */
@NamedQueries({
@NamedQuery(name = "getAllCustomers", query = "SELECT cust FROM Customer cust"),
@NamedQuery(name = "getCustomerIds", query = "SELECT custId FROM Customer cust"),
@NamedQuery(name = "deleteCustomerById",  query = "DELETE FROM Customer cust WHERE cust.custId=:cId")})  
public class Customer {

	@Id
	@Column(name="custId")
	@NotNull(message="user Id is required")
	private int custId;
	
	@NotEmpty(message="user name is required")					//For string use NotEmpty.
	@Size(min=4,message="user name should have atleast 4 character")
	private String custName;
	
	@NotNull(message="Mobile number is required")	
	@Length(min=10,max=10,message="Please enter valid number")
	//@Size(min=5,message="user name should have atleast 4 character")

	private String mobile;
	
	@NotEmpty(message="Email is required")
	private String email;
	
	
								//Validation part
	@NotNull(message="DOB is required")
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Past
	private Date birthDate;
	
	

	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
}
