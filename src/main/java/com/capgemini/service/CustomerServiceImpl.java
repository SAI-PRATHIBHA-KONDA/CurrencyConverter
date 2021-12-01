package com.capgemini.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.exceptions.CustomerNotFoundException;
import com.capgemini.model.Bank;

import com.capgemini.model.Customer;
import com.capgemini.repository.BankRepository;
import com.capgemini.repository.CustomerRepository;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private BankRepository bankRepository;
	

	
	@Override
	public boolean addUser(Customer customer) {
		boolean result = false;
		customer=customerRepository.save(customer);
		if (customer.getCustomerId()>0)
			result = true;
		return result;
	}

	@Override
	public boolean loginUser(String customerName,String password) {
		boolean result = false;
		Customer user2 = customerRepository.validateCustomer(customerName,password);
		if (user2 != null) {
			result = true;

		}
		return result;
	}

	@Override
	public Customer viewUser(Integer customerId) throws CustomerNotFoundException {
		if(customerRepository.existsById(customerId)) {
			return customerRepository.findById(customerId).get();
		}
		throw new CustomerNotFoundException("User with ID:"+customerId+"not found");
	}

	@Transactional
	@Override
	public boolean updateUser(Customer customer) {
		customerRepository.updateCustomer(customer.getCustomerName(), customer.getPassword(),customer.getMail(),customer.getCustomerId());
		return true;
	}

	@Override
	@Transactional
	public boolean deleteUser(Integer customerId) throws CustomerNotFoundException {
		if (customerRepository.existsById(customerId)) {
			customerRepository.deleteById(customerId);
			return true;
		}
		throw new CustomerNotFoundException("Customer with Id not found");
		}

	@Override
	public boolean addBankDetails(Bank bank) {
		boolean result = false;
		bank =bankRepository.save(bank);
		if (bank.getAccountNumber()>0)
			result = true;
		return result;
	}

	@Override
	public List<Bank> viewBankDetails() {
		return bankRepository.findAll();
		
	}

	@Override
	@Transactional
	public boolean deleteBank(long accountNumber) {
		if (bankRepository.existsById(accountNumber)) {
			bankRepository.deleteById(accountNumber);
			return true;
		}
		return false;
		}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}
	
	
}
