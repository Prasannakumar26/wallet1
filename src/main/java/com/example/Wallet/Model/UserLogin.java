package com.example.Wallet.Model;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "UserLogin")
public class UserLogin {
	
	
	@Override
	public String toString() {
		return "UserLogin [mobileNumber=" + mobileNumber + ", password=" + password + "]";
	}
	public UserLogin(String mobileNumber, String password) {
		super();
		this.mobileNumber = mobileNumber;
		this.password = password;
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
	private String mobileNumber;
	private String password;
	
	
	public UserLogin() {};

}
