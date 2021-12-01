package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.exceptions.CustomerNotFoundException;
import com.capgemini.model.Admin;
import com.capgemini.model.Bank;

import com.capgemini.model.Customer;
import com.capgemini.service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin
@RestController
public class CustomerController {
	
	@Autowired
	public CustomerService service;
	
	@PostMapping(path = "/saveUser")
	public ResponseEntity<String> saveUser(@RequestBody Customer user)
	{
		ResponseEntity<String> response = null;
		boolean result = service.addUser(user);
		if (result)
		{
			response = new ResponseEntity<String>("User with id " + user.getCustomerId()+ " is created.", HttpStatus.CREATED);
		}
		return response;
	}
	
	@PostMapping(path = "/Customerlogin/{customerName}/{password}")
	public ResponseEntity<String> checkCusotmerLogin(@PathVariable("customerName") String customerName,@PathVariable("password") String password) 
	{
		ResponseEntity<String> response = null;
		boolean result = service.loginUser(customerName,password);
		if (result) 
		{
			response = new ResponseEntity<String>("Username and Password is correct", HttpStatus.OK);
		}
		else 
		{
			response = new ResponseEntity<String>("Username and Password is incorrect",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@GetMapping(path = "searchById/{customerId}")
	public ResponseEntity<Customer> getUserById(@PathVariable("customerId") int customerId)
			throws CustomerNotFoundException {
		ResponseEntity<Customer> response = null;
		Customer user = service.viewUser(customerId);
		response = new ResponseEntity<Customer>(user, HttpStatus.OK);
		return response;
	}
	
	@GetMapping(path = "/viewAllBankDetails")
    public ResponseEntity<List<Bank>> getBankDetails() {
        ResponseEntity<List<Bank>> response;
        List<Bank> list = service.viewBankDetails();
        response = new ResponseEntity<List<Bank>>(list, HttpStatus.OK);
        return response;
    }
	
	
	
	@PostMapping(path = "/saveBankDetails")
	public ResponseEntity<String> saveBankDetails(@RequestBody Bank bank)
	{
		ResponseEntity<String> response = null;
		boolean result = service.addBankDetails(bank);
		if (result)
		{
			response = new ResponseEntity<String>(" User with accountNumber- " + bank.getAccountNumber() + " IFSC - " +  bank.getIFSC() + "accountHolderName- " + bank.getAccountHolderName() + " is added.", HttpStatus.CREATED);
		}
		return response;
	}
	
	@DeleteMapping(path = "deleteCustomerById/{customerId}")
	public ResponseEntity<String> removeUser(@PathVariable("customerId") Integer customerId) throws CustomerNotFoundException {
		ResponseEntity<String> response = null;
		if (service.deleteUser(customerId)) {
			response = new ResponseEntity<String>("Customer with given ID is deleted", HttpStatus.OK);
		}
		return response;
	}
	
	@DeleteMapping(path = "deleteBankById/{accountNumber}")
	public ResponseEntity<String> removeBank(@PathVariable("accountNumber") long accountNumber) throws CustomerNotFoundException {
		ResponseEntity<String> response = null;
		if (service.deleteBank(accountNumber)) {
			response = new ResponseEntity<String>(" Bank details with given Account Number is deleted", HttpStatus.OK);
		}
		return response;
	}
	
	@PutMapping(path = "/updateById")
    public ResponseEntity<String> updateCustomerById(@RequestBody Customer customer){
        ResponseEntity<String> response = null;
        boolean result = service.updateUser(customer);
        if (result) {
            response = new ResponseEntity<String>(
                    "Customer with Id" + customer.getCustomerId() + "is successfully updated", HttpStatus.OK);
        }
        return response;
    }
	
	
	@GetMapping(path = "/listAllCustomers")
	public ResponseEntity<List<Customer>> getAllExistingCustomers() 
	{
		ResponseEntity<List<Customer>> response = null;
		List<Customer> list = service.getAllCustomer();
		response = new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
		return response;
	}
	
	

}
