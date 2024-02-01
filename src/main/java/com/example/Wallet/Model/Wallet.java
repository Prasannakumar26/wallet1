package com.example.Wallet.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Wallet {
	
	
	
	
	
	public Wallet(Customer customer) {
		super();
		this.customer = customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Wallet(Customer customer, Integer walletId, Double balance) {
		super();
		this.customer = customer;
		this.walletId = walletId;
		this.balance = balance;
	}
    @OneToOne(cascade = CascadeType.PERSIST)

    @JoinColumn(name = "customer_id")
	private Customer customer;
	
	public Wallet(Integer walletId, double balance) {
		super();
		this.walletId = walletId;
		this.balance = balance;
	}
	public Integer getWalletId() {
		return walletId;
	}
	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}
	@Override
	public String toString() {
		return "Wallet [customer=" + customer + ", walletId=" + walletId + ", balance=" + balance + "]";
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer walletId;
	private Double balance;
	
	public Wallet() {}
	public void setBalance(int i) {
		// TODO Auto-generated method stub
		
	};

}
