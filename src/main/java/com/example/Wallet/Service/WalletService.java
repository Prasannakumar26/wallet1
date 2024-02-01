package com.example.Wallet.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Wallet.Model.BankAccount;
import com.example.Wallet.Model.Beneficiary;
import com.example.Wallet.Model.CurrentSession;
import com.example.Wallet.Model.Customer;
import com.example.Wallet.Model.TransferRequest;
import com.example.Wallet.Repository.BankAccountRepository;
import com.example.Wallet.Repository.BeneficiaryRepository;
import com.example.Wallet.Repository.CurrentSessionRepository;
import com.example.Wallet.Repository.CustomerRepository;
import com.example.Wallet.Repository.WalletRepository;
import com.example.Wallet.Model.Wallet;

@Service
public class WalletService {
	
	
	@Autowired
	private WalletRepository walletRepository;
	
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CurrentSessionRepository currentSessionRepo;
	
	
	
	@Autowired
	private BankAccountRepository bankAccountRep;
	
	@Autowired
	private BeneficiaryRepository beneficiaryRep;
	
	//---------------------------------------Creating Account--------------------------------------------------------------//
	 
	public Customer userCreation(Customer customer) throws Exception{
		    List<Customer>    customers  = customerRepository.findCustomerByMobile(customer.getMobileNumber());
		    
		    if(customers.isEmpty()) {
		    	customerRepository.save(customer);
		        
				Wallet wallet = new Wallet();
				wallet.setBalance(0);
				wallet.setCustomer(customer);
				walletRepository.save(wallet);

				
		    }else {
		    throw new Exception("duplicate user");
		    }
		    return customer;
	}
	//---------------------------------------------Add Money to Wallet-----------------------------------------//
	
	public String addAmountToWallet(String key,Long accountNo,Integer amount)throws Exception {
		
		
		     CurrentSession currentSession = currentSessionRepo.findByUuid(key);
		     if(currentSession == null) {
		    	 throw new Exception("user not logged in");
		     }
		     Integer userid  = currentSession.getUserId();
		     Wallet wallet   = walletRepository.showCustomerWalletDetails(userid);
		     List<BankAccount>    bankAccounts     = bankAccountRep.findAllByWallet(wallet.getWalletId());
		     if(bankAccounts == null) {
		    	 throw new Exception("Add BankAccount for transaction");
		     }
		     BankAccount bankAccount = null;
		     for(BankAccount b: bankAccounts) {
		    	 if((b.getAccountNo().toString()).equals(accountNo.toString())) {
		    		    bankAccount = b;
						break;
					}		     }
		     if(bankAccount == null) {
		    	 throw new Exception("Bank Account number does not match in the bank details in this wallet");
		     }
		     if(bankAccount.getBalance()<amount) {
		    	 throw new Exception("Insufficent Balance in Bank Account for this transaction");
		     }
		     bankAccount.setBalance(bankAccount.getBalance()-amount);
		     wallet.setBalance(wallet.getBalance()+amount);
		     bankAccountRep.save(bankAccount);

		     return "Your bank account no "+ accountNo +" debited for "+ amount +" Rs" ;
		
	}
	//-----------------------------------------Fund Transfer--------------------------------------------------------------------//
	
	public String fundTransfer(String key,TransferRequest transferRequest) throws Exception{
		
		CurrentSession     existinguser         = currentSessionRepo.findByUuid(key);
		if(existinguser == null) {
			throw new Exception("customer not logged in ");
		}
		    Wallet walletDetails = walletRepository.showCustomerWalletDetails(existinguser.getUserId());
		    Beneficiary beneficiary = new Beneficiary(transferRequest.getName(),transferRequest.getMobileNumber());
		    List<Beneficiary>   beneficiaries = beneficiaryRep.findByWallet(walletDetails.getWalletId());
		    
		    if(!beneficiaries.contains(beneficiary)) beneficiaryRep.save(beneficiary);
		    
		        List<Customer>  customers   = customerRepository.findCustomerByMobile(transferRequest.getMobileNumber());
		        if(customers.isEmpty()) {
		        	throw new Exception("customer with MobileNumber" + transferRequest.getMobileNumber()+"not exists");
		        }
		        Wallet targetWallet = walletRepository.showCustomerWalletDetails(customers.get(0).getCustomerId());
		        if(walletDetails.getBalance().compareTo(transferRequest.getAmount())<0) {
		        	throw new Exception("Due to insufficient balance in wallet add more amout for this transaction");
		        	
		        }
				targetWallet.setBalance(targetWallet.getBalance()+transferRequest.getAmount());
				walletRepository.save(targetWallet);
                
				walletDetails.setBalance(walletDetails.getBalance()-transferRequest.getAmount());
				walletRepository.save(walletDetails);
				
				return "Fund Transferred successfully";

				
		
	}

}
