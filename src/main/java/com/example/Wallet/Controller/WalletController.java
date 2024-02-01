package com.example.Wallet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Wallet.Model.Customer;
import com.example.Wallet.Repository.WalletRepository;
import com.example.Wallet.Service.WalletService;



@RestController
@RequestMapping("/api")
public class WalletController {
	
	
	
	@Autowired
	private WalletService walletService;
	//----------------------------------------Create Customer------------------------------------------------//
	
	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> customerRegister(@RequestBody Customer customer) throws Exception{
		     Customer  cust1  = walletService.userCreation(customer);
		     if(cust1 != null) {
		    	   return new ResponseEntity<>(cust1,HttpStatus.OK); 
		       }else {
		            

                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		       }	
	}

	
	//-----------------------------------AddAmount to Wallet------------------------------------------------------//
	@PostMapping("/addAmount")
	public ResponseEntity<String> addAmountToWallet(@RequestParam String key,@RequestParam Long accountNo,@RequestParam Integer amount) throws Exception{
		
		
		
		
		return new ResponseEntity<String>(walletService.addAmountToWallet(key, accountNo,  amount), HttpStatus.OK);
	}

}
