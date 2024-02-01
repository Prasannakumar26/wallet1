package com.example.Wallet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Wallet.Model.BankAccount;
import com.example.Wallet.Model.Wallet;
import com.example.Wallet.Service.BankAccountService;

@RestController
@RequestMapping("/api")
public class BankAccountController {
	
	
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@PostMapping("/addBankAccount")
	public ResponseEntity<String > addBankAccount1(@RequestParam String key,@RequestBody BankAccount bankAccount) throws Exception {
		
		Wallet wallet  = bankAccountService.addBankAccount(key, bankAccount);
		
		return new ResponseEntity<String>("Bank Account Added Successfully",HttpStatus.CREATED);
		
	}
	

}
