package com.example.Wallet.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Beneficiary {
	
	
	
	
	@Override
	public String toString() {
		return "Beneficiary [beneficiaryName=" + beneficiaryName + ", beneficiaryNumber=" + beneficiaryNumber
				+ ", wallet=" + wallet + "]";
	}

	public Beneficiary(String beneficiaryName, String beneficiaryNumber, Wallet wallet) {
		super();
		this.beneficiaryName = beneficiaryName;
		this.beneficiaryNumber = beneficiaryNumber;
		this.wallet = wallet;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getBeneficiaryNumber() {
		return beneficiaryNumber;
	}

	public void setBeneficiaryNumber(String beneficiaryNumber) {
		this.beneficiaryNumber = beneficiaryNumber;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
    @Id
    @NotNull
	private String beneficiaryNumber;
    private String beneficiaryName;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "walletId",referencedColumnName = "walletId")
	private Wallet wallet;
	
    public Beneficiary() {}

	public Beneficiary(String name, String mobileNumber) {
		// TODO Auto-generated constructor stub
	}

	public Beneficiary(String name, Integer mobileNumber) {
		// TODO Auto-generated constructor stub
	};
    
}
