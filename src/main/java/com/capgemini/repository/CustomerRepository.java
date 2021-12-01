package com.capgemini.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	@Transactional
	@Modifying
	@Query(value="Update Customer u set u.customerName=:customerName,u.password=:password,u.mail=:mail where u.customerId=:customerId")
	public void updateCustomer(@Param("customerName") String customerName,@Param("password") String password,@Param("mail") String mail,@Param("customerId") int customerId);
	
	@Query(value="Select u from Customer u where u.customerName = :customerName And u.password = :password")
	public Customer validateCustomer(@Param("customerName") String customerName ,@Param("password") String password);
	
}
