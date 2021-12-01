package com.capgemini.service;

import java.math.BigDecimal;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.model.Admin;
import com.capgemini.model.Bank;
import com.capgemini.model.ConversionRequestIn;
import com.capgemini.model.Customer;
import com.capgemini.repository.AdminRepository;
import com.capgemini.repository.BankRepository;

import com.capgemini.repository.CustomerRepository;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
//	@Autowired
//	private CurrenciesRepository currenciesRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public boolean addAdmin(Admin admin) {
		boolean result = false;
		admin = adminRepository.save(admin);
		if (admin.getAdminId()>0)
			result = true;
		return result;
	}

	@Override
	public boolean loginAdmin(Admin admin) {
		boolean result = false;
		Admin admin2 = adminRepository.validateAdmin(admin.getAdminId(),admin.getPassword());
		if (admin2 != null) {
			result = true;

		}
		return result;
	}
	

	@Override
	public List<Bank> viewBankDetails() {
		return bankRepository.findAll();
		
	}

	@Override
	public List<Customer> viewAllCustomer() {
		 return customerRepository.findAll();
	}

	@Override
	@Transactional
	public boolean deleteCustomerById(Integer customerId) {
		if (customerRepository.existsById(customerId)) {
			customerRepository.deleteById(customerId);
			return true;
		}
		return false;
		}


	
	@Autowired
	@Override
	public void mailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
		
	}


	@Override
	public void sendConversionEmail(String fromCurrency, String toCurrency, BigDecimal multiply) throws MessagingException{
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setTo("durgalavanyavedullapalli@gmail.com");
		helper.setSubject("Currency Conversion confirmed");
		helper.setText("GREETINGS! IF YOU CAN'T VIEW THIS MAIL, PLEASE OPEN IN CHROME"+"\n"
				+"\nThis is a system generated mail DO NOT REPLY"+"\n"
				 +"\n Convertion of  " + multiply
				 + "\n from " + fromCurrency
				+ "\n to " + toCurrency
				
				+"\n"+" is confirmed.:)");

		javaMailSender.send(mimeMessage);
		
	}


	
	
	
	
	
	
	
	
//	@Override
//	public void sendConversionEmail(ConversionRequestIn conversionRequestIn) throws MessagingException {
//		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//
//		helper.setTo("durgalavanyavedullapalli@gmail.com");
//		helper.setSubject("Currency Conversion confirmed");
//		helper.setText("GREETINGS! IF YOU CAN'T VIEW THIS MAIL, PLEASE OPEN IN CHROME"+"\n"
//				+"\nThis is a system generated mail DO NOT REPLY"+"\n"
//				 +"\n Convertion of  " + conversionRequestIn.getAmount()
//				 + "\n from " + conversionRequestIn.getFrom()
//				+ "\n to " + conversionRequestIn.getTo()
//				
//				+"\n"+" is confirmed.:)");
//
//		javaMailSender.send(mimeMessage);
//		
//	}

	
	
	
	
	
	
	
	
//	@Override
//	public Currencies viewCurrenciesByname() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean updateCurrencies(Currencies currencies) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	
}
