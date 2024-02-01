package com.example.Wallet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Wallet.Model.Customer;
import com.example.Wallet.Model.UserLogin;
import com.example.Wallet.Model.Wallet;
import com.example.Wallet.Repository.CustomerRepository;
import com.example.Wallet.Service.CustomerService;
import com.example.Wallet.Service.UserLoginService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired 
	private CustomerService customerService;
	
	
	
	

	
	

	
	 
}
