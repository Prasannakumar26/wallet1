package com.example.Wallet.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Wallet.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	@Query("FROM Customer c WHERE c.mobileNumber=?1")
	public List<Customer> findCustomerByMobile(String mobileNumber);
	

}
