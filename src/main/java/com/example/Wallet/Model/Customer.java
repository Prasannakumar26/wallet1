package com.example.Wallet.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class Customer {
	
	
	
	
	
	
	
	public Customer(Wallet wallet) {
		super();
	}

	@Override
	public String toString() {
		return "Customer [wallet="  + ", customerId=" + customerId + ", customerName=" + customerName
				+ ", mobileNumber=" + mobileNumber + ", password=" + password + "]";
	}
	public Customer(Integer customerId, String customerName, String mobileNumber, String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer customerId;
	private String  customerName;
	
	private String  mobileNumber;
	private String  password;
	
	
	public Customer() {}
	

	

}
