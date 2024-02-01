package com.example.Wallet.Model;

import javax.persistence.Entity;


public class TransferRequest {
	
	
	
	private String name;
	@Override
	public String toString() {
		return "TransferRequest [name=" + name + ", mobileNumber=" + mobileNumber + ", amount=" + amount + "]";
	}
	public TransferRequest(String name, String mobileNumber, Double amount) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	private String mobileNumber;
	private Double amount;

}
