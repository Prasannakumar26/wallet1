package com.example.Wallet.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Wallet.Model.Beneficiary;
import com.example.Wallet.Model.CurrentSession;
import com.example.Wallet.Model.Customer;
import com.example.Wallet.Model.Wallet;
import com.example.Wallet.Repository.BeneficiaryRepository;
import com.example.Wallet.Repository.CurrentSessionRepository;
import com.example.Wallet.Repository.CustomerRepository;
import com.example.Wallet.Repository.WalletRepository;

@Service
public class BeneficiaryService {
	
	
	@Autowired
	private CurrentSessionRepository currentSessionRep;
	@Autowired
	private CustomerRepository customerRep;
	@Autowired
	private WalletRepository walletRepo;
	
	@Autowired
	private BeneficiaryRepository beneficiaryRepo;
	
	
	//----------------------------------------------Adding Beneficiary--------------------------------------//
	
	public Beneficiary addBeneficiary(String key,Beneficiary beneficiary)throws Exception {
		     CurrentSession   currentuser          = currentSessionRep.findByUuid(key); 
		     if(currentuser == null) {
		    	  throw new Exception("User not logged in");
		     }
		     
		      Optional<Customer> customer1   = customerRep.findById(currentuser.getUserId());
		      Optional<Wallet> wallet = walletRepo.findById(walletRepo.showCustomerWalletDetails(currentuser.getUserId()).getWalletId());
		     if(!customer1.isPresent()) {
		    	 throw new Exception("beneficiary doesn't registered with this application");
		    	 
		     }
		     if (!wallet.isPresent()){
		         throw new Exception("Invalid User.");
		      }

		      Optional<Beneficiary> optional1=beneficiaryRepo.findById(beneficiary.getBeneficiaryNumber());

		      if(optional1.isEmpty()) {
		         return  beneficiaryRepo.save(beneficiary);
		      }
		      throw new Exception("Duplicate Details [ Beneficiary Already Exist ]");


		     
		  
	}

}
