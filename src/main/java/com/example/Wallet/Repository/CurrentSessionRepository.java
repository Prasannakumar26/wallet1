package com.example.Wallet.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Wallet.Model.CurrentSession;

public interface CurrentSessionRepository extends JpaRepository<CurrentSession, Integer>{
	
	@Query("FROM CurrentSession a WHERE a.userId=?1")
	public Optional<CurrentSession> findByUserId(Integer userId);
	
	public CurrentSession findByUuid(String key);

}
