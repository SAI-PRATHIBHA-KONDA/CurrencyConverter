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
import com.capgemini.service.AdminService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin
@RestController
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	
	@PostMapping(path = "Adminlogin")
	public ResponseEntity<String> checkAdminLogin(@RequestBody Admin admin) 
	{
		ResponseEntity<String> response = null;
		boolean result = service.loginAdmin(admin);
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
	
	@PostMapping(path = "saveAdmin")
	public ResponseEntity<String> saveAdmin(@RequestBody Admin admin)
	{
		ResponseEntity<String> response = null;
		boolean result = service.addAdmin(admin);
		if (result)
		{
			response = new ResponseEntity<String>("Admin with id " + admin.getAdminId()+ " is created.", HttpStatus.CREATED);
		}
		return response;
	}
	

	
	
	@GetMapping(path = "/viewBankDetails")
    public ResponseEntity<List<Bank>> getBankDetails() {
        ResponseEntity<List<Bank>> response;
        List<Bank> list = service.viewBankDetails();
        response = new ResponseEntity<List<Bank>>(list, HttpStatus.OK);
        return response;
    }
	
	@GetMapping(path = "/viewAllCustomer")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        ResponseEntity<List<Customer>> response;
        List<Customer> list = service.viewAllCustomer();
        response = new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
        return response;
    }
	
	
	@DeleteMapping(path = "deleteCusotmerById/{customerId}")
	public ResponseEntity<String> removeCustomerById(@PathVariable("customerId") Integer customerId) throws CustomerNotFoundException {
		ResponseEntity<String> response = null;
		if (service.deleteCustomerById(customerId)) {
			response = new ResponseEntity<String>(" Customer with given Customer Id is deleted", HttpStatus.OK);
		}
		return response;
	}
	
	
	
	
//	@PostMapping(path = "saveCurrencies")
//	public ResponseEntity<String> saveCurrencies(@RequestBody CurrenciesConverter currencies)
//	{
//		ResponseEntity<String> response = null;
//		boolean result = service.addCurrencies(currencies);
//		if (result)
//		{
//			response = new ResponseEntity<String>("Currencies with id " + currencies.getId()+ " is created.", HttpStatus.CREATED);
//		}
//		return response;
//	}
//	
//	@GetMapping(path = "/viewCurrencies")
//    public ResponseEntity<List<CurrenciesConverter>> getAllCurrencies() {
//        ResponseEntity<List<CurrenciesConverter>> response;
//        List<CurrenciesConverter> list = service.viewCurrencies();
//        response = new ResponseEntity<List<CurrenciesConverter>>(list, HttpStatus.OK);
//        return response;
//    }
	

}
