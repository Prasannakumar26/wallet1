
package com.example.Wallet.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.Wallet.Model.CurrentSession;
import com.example.Wallet.Model.Customer;
import com.example.Wallet.Model.UserLogin;
import com.example.Wallet.Repository.CurrentSessionRepository;
import com.example.Wallet.Repository.CustomerRepository;

import net.bytebuddy.utility.RandomString;

@Service

public class UserLoginService {
	
	
	
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CurrentSessionRepository currentSessionRep;
	
	
	
	//---------------------------------------Login----------------------------------------------------------------//

	public String userLogin(UserLogin userLogin) throws Exception{
	
		   
		   List<Customer> customer = customerRepository.findCustomerByMobile(userLogin.getMobileNumber());
		   
		   Customer  existingCustomer   = customer.get(0);
		      
		    if(existingCustomer == null) {
                     
		    	
		     throw new Exception("Invalid MobileNumber");
		   
		  
 	             }
		    Optional<CurrentSession> optional   = currentSessionRep.findById(existingCustomer.getCustomerId());
            if(optional.isPresent()) {
            	throw new Exception("User Already logged in this system");
            }
            if(existingCustomer.getPassword().equals(userLogin.getPassword())) {
            	String key = RandomString.make(6);
            	CurrentSession currentSession = new CurrentSession(existingCustomer.getCustomerId(),key,LocalDateTime.now());
            	
            	currentSessionRep.save(currentSession);
            	
            	return currentSession.toString();
            }
            throw new Exception("Invalid Password");
	}
}
