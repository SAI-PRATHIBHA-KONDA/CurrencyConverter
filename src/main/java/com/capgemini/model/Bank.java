package com.capgemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("bank")
@Scope(scopeName="prototype")
@Entity
@Table(name="BANK")
public class Bank {
	@Column
	@Id
	private long accountNumber;
	
	@Column
	private String IFSC;
	
	@Column
	private String accountHolderName;
	
	public Bank() {
		
		
	}
	
	public Bank(long accountNumber, String iFSC, String accountHolderName) {
		super();
		this.accountNumber = accountNumber;
		IFSC = iFSC;
		this.accountHolderName = accountHolderName;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIFSC() {
		return IFSC;
	}
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	
	@Override
	public String toString() {
		return "Bank [accountNumber=" + accountNumber + ", IFSC=" + IFSC + ", accountHolderName=" + accountHolderName
				+ "]";
	}
	
	
}
