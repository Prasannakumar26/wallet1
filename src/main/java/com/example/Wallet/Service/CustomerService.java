package com.example.Wallet.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Wallet.Model.Customer;
import com.example.Wallet.Repository.CustomerRepository;



@Service
public class CustomerService {
	
	

	@Autowired
	private CustomerRepository customerRepository;
	
	
	public Customer getRegister(String fullname,String mobileNumber,String password) {
		
		
		       if(fullname == null || mobileNumber == null || password == null) {
	    			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Enter All Fields");
		       }
		       Customer customer = new Customer();
		       customer.setCustomerName(fullname);
		       customer.setMobileNumber(mobileNumber);
		       customer.setPassword(password);
		       
		   return    customerRepository.save(customer);
		
	}

}
