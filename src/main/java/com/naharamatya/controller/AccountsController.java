package com.naharamatya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naharamatya.constants.AccountsConstants;
import com.naharamatya.dto.CustomerDTO;
import com.naharamatya.dto.ResponseDTO;
import com.naharamatya.service.AccountsService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("/api")
@Validated
public class AccountsController {

	@Autowired
	private AccountsService accountsService;

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CustomerDTO customerDto) {
		accountsService.createAccount(customerDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseDTO(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
	}

	@GetMapping("/fetch/{mobileNumber}")
	public ResponseEntity<CustomerDTO> fetchAccountDetailsByMobileNumber(@Valid @PathVariable 
			@Pattern(regexp="(^$|[0-9]{10})", message="Mobile number must be 10 digits") String mobileNumber) {
		CustomerDTO customerDto = new CustomerDTO();

		customerDto = accountsService.fetchAccountDetailsByMobileNumber(mobileNumber);

		return ResponseEntity.status(HttpStatus.OK).body(customerDto);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateAccountDetails(@Valid @RequestBody CustomerDTO customerDto) {

		boolean updated = false;

		updated = accountsService.updateAccountDetails(customerDto);

		if (updated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDTO(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseDTO(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
		}

	}
	
	@DeleteMapping("/delete/{mobileNumber}")
	public ResponseEntity<ResponseDTO> deleteAccount(@Valid @PathVariable 
			@Pattern(regexp="(^$|[0-9]{10})", message="Mobile number must be 10 digits") String mobileNumber){
		
		boolean updated = false;
		
		updated = accountsService.deleteAccount(mobileNumber);
		
		if(updated) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDTO(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
		}
		
	}
}
