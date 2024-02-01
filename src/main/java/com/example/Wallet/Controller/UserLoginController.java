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
import com.example.Wallet.Service.UserLoginService;

@RestController
@RequestMapping("/api")
public class UserLoginController {
	
	
	
	
	@Autowired
	private UserLoginService userLoginService;
	
	
	@PostMapping("/login")
	public ResponseEntity<String> userLogin1(@RequestBody UserLogin userLogin) throws Exception {
		         
		 String userlog = userLoginService.userLogin(userLogin);
		 
  	   return new ResponseEntity<>(userlog,HttpStatus.OK); 

	}

}
