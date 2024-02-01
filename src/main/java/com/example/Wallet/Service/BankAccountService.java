package com.example.Wallet.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Wallet.Model.BankAccount;
import com.example.Wallet.Model.CurrentSession;
import com.example.Wallet.Model.Wallet;
import com.example.Wallet.Repository.BankAccountRepository;
import com.example.Wallet.Repository.CurrentSessionRepository;
import com.example.Wallet.Repository.WalletRepository;

@Service
public class BankAccountService {
	
	
	@Autowired
	private CurrentSessionRepository currentSessionRep;
	
    @Autowired
    private WalletRepository walletRepository;
    
    
    @Autowired
    private BankAccountRepository bankAccountRepository;
    
  //-------------------------------------------AddBankAccount----------------------------------------------------//  
    public Wallet addBankAccount(String key,BankAccount bankAccount) throws Exception {
    	    CurrentSession  existingUser  = currentSessionRep.findByUuid(key);
    	    if(existingUser == null) {
    	    	throw new Exception("User Not Logged In");
    	    }
    	    
    	    Optional<BankAccount> bankaccount = bankAccountRepository.findById(bankAccount.getAccountNo());
    	    if(bankaccount.isEmpty()) {
    	    	
    	    	Wallet wallet = walletRepository.showCustomerWalletDetails(existingUser.getUserId());
    	    	BankAccount bankacc = new BankAccount(bankAccount.getAccountNo(),bankAccount.getIfsc(),bankAccount.getBalance());
    	    	bankacc.setWallet(wallet);
    	    	bankAccountRepository.save(bankacc);
    	    	
    	    	return wallet;
    	    	
    	    	
    	    }
    	    else {
    	    	throw new Exception("Bank Account already exist With Given AccountNumber... Try Different");
    	    }
    	
    }
	
	
	
	
	
	

	
	
	
	
	
	

}
