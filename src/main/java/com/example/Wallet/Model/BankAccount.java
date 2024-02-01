package com.example.Wallet.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ValueGenerationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder

@Table(name = "bankaccount")
public class BankAccount {
	
	
	
	
	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", ifsc=" + ifsc + ", balance=" + balance + ", wallet=" + wallet
				+ "]";
	}
	public BankAccount(Long accountNo, String ifsc, Integer balance) {
		super();
		this.accountNo = accountNo;
		this.ifsc = ifsc;
		this.balance = balance;
	}
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	@Id
	private Long accountNo;
	private String ifsc;
	private Integer balance;
	
	
	public BankAccount() {};
	
	
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	@ManyToOne(cascade= CascadeType.PERSIST)
	private Wallet wallet;

}
