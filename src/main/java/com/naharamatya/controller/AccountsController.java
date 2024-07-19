package com.naharamatya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naharamatya.constants.AccountsConstants;
import com.naharamatya.dto.CustomerDTO;
import com.naharamatya.dto.ResponseDTO;
import com.naharamatya.service.AccountsService;

@RestController
@RequestMapping("/api")
public class AccountsController {
	
	@Autowired
	private AccountsService accountsService;
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createAccount(@RequestBody CustomerDTO customerDto){
		accountsService.createAccount(customerDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
	}
}
