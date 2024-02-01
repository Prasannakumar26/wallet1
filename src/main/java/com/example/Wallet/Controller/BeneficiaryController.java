package com.example.Wallet.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Wallet.Model.Beneficiary;
import com.example.Wallet.Model.Customer;
import com.example.Wallet.Service.BeneficiaryService;

@RestController
@RequestMapping("/api")
public class BeneficiaryController {
	
	
	
	
	@Autowired
	private BeneficiaryService beneficiaryService;
	//---------------------------------------Add Beneficiary---------------------------------------------------//
	@PostMapping("/addBeneficiary")
	public ResponseEntity<Beneficiary> addBeneficiary(@RequestParam String key,@RequestBody Beneficiary beneficiary) throws Exception{
		return new ResponseEntity<Beneficiary>(beneficiaryService.addBeneficiary(key, beneficiary),HttpStatus.ACCEPTED);
	}
	

}
