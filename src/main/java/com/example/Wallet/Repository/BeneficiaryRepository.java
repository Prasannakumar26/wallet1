package com.example.Wallet.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Wallet.Model.Beneficiary;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary,String>{
	
	  @Query(value = "FROM Beneficiary b INNER JOIN b.wallet w WHERE w.walletId=?1")
	   public List<Beneficiary> findByWallet(Integer walletId);	

}
