package com.example.Wallet.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Wallet.Model.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount,Long>{
	
	@Query(value = "FROM BankAccount b INNER JOIN b.wallet w WHERE w.walletId=?1")
	public List<BankAccount>  findByWallet(Integer walletId);
	
    public Optional<BankAccount> findById(long accountNo);
    
	@Query(value = "FROM BankAccount b INNER JOIN b.wallet w WHERE w.walletId=?1")
	public List<BankAccount> findAllByWallet(Integer walletId);

}
