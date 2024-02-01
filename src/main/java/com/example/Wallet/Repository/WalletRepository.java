package com.example.Wallet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Wallet.Model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet,Integer>{
    @Query("FROM Wallet w INNER JOIN w.customer c WHERE c.customerId=?1")
    public Wallet showCustomerWalletDetails(Integer customerId);
	
	

}
