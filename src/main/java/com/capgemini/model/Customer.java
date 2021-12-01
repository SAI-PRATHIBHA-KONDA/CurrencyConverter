package com.capgemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("customer")
@Scope(scopeName = "prototype")
@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Column(name = "CUSTOMER_NAME", length = 50)
	private String customerName;

	@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	@Column
	private String password;
	
	@Column
	private String mail;

	public Customer() {

	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerId=" + customerId + ", password=" + password + "]";
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Customer(String customerName, Integer customerId, String password, String mail) {
		super();
		this.customerName = customerName;
		this.customerId = customerId;
		this.password = password;
		this.mail = mail;
	}

	
	
	
}


