package com.capgemini.model;

import java.util.Date;

public class InvoicePdf {

	String customerFirstName;
	String customerLastName;
	Date dateOfExchange;
	double amount;
	double transactionFee;
	String from;
	String to;
	//add phone number or mail.

	public InvoicePdf() {

	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public Date getDateOfExchange() {
		return dateOfExchange;
	}

	public void setDateOfExchange(Date dateOfExchange) {
		this.dateOfExchange = dateOfExchange;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getTransactionFee() {
		return transactionFee;
	}

	public void setTransactionFee(double transactionFee) {
		this.transactionFee = transactionFee;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public InvoicePdf(String customerFirstName, String customerLastName, Date dateOfExchange, double amount,
			double transactionFee, String from, String to) {
		super();
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.dateOfExchange = dateOfExchange;
		this.amount = amount;
		this.transactionFee = transactionFee;
		this.from = from;
		this.to = to;
	}

	@Override
	public String toString() {
		return "InvoicePdf [customerFirstName=" + customerFirstName + ", customerLastName=" + customerLastName
				+ ", dateOfExchange=" + dateOfExchange + ", amount=" + amount + ", transactionFee=" + transactionFee
				+ ", from=" + from + ", to=" + to + "]";
	}

}
