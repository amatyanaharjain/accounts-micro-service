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
import com.naharamatya.dto.ErrorResponseDTO;
import com.naharamatya.dto.ResponseDTO;
import com.naharamatya.service.AccountsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@Tag(name = "CRUD Rest API for Accounts Micro Service", description = "CRUD Rest API to CREATE, UPDATE, FETCH and DELETE account details")
@RestController
@RequestMapping("/api")
@Validated
public class AccountsController {

	@Autowired
	private AccountsService accountsService;

	@Operation(
			summary = "CREATE ACCOUNT REST API",
			description = "REST API to create new customer and account"
			)
	@ApiResponses({
		@ApiResponse(
				responseCode = "201",
				description = "HttpStatus 201 CREATED"
				),
		@ApiResponse(
				responseCode = "500",
				description = "HttpStatus 500 Internal Server Error",
				content = @Content(
						schema = @Schema(implementation = ErrorResponseDTO.class)
						)
				)
		
	})
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CustomerDTO customerDto) {
		accountsService.createAccount(customerDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseDTO(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
	}

	@Operation(
			summary = "FETCH Account details REST API",
			description = "REST API to fetch customer and account details using a mobile number"
			)
	
	@ApiResponses({
		@ApiResponse(
				responseCode = "200",
				description = "HTTP Status OK"
				)
		,
		@ApiResponse(
				responseCode = "500",
				description = "HttpStatus 500 Internal Server Error",
				content = @Content(
						schema = @Schema(implementation = ErrorResponseDTO.class)
						)
				)
		
	})
	@GetMapping("/fetch/{mobileNumber}")
	public ResponseEntity<CustomerDTO> fetchAccountDetailsByMobileNumber(
			@Valid @PathVariable @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") String mobileNumber) {
		CustomerDTO customerDto = new CustomerDTO();

		customerDto = accountsService.fetchAccountDetailsByMobileNumber(mobileNumber);

		return ResponseEntity.status(HttpStatus.OK).body(customerDto);
	}

	@Operation(
			summary="UPDATE Account details REST API",
			description="REST API to update customer and account details using account number"
			)
	@ApiResponses({
			@ApiResponse(
					responseCode = "200",
					description = "HttpStatus 200 OK"),
			@ApiResponse(
					responseCode = "417",
					description = "Expectation Failed"
					)
			,
			@ApiResponse(
					responseCode = "500",
					description = "HttpStatus 500 Internal Server Error",
					content = @Content(
							schema = @Schema(implementation = ErrorResponseDTO.class)))
	})
	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateAccountDetails(@Valid @RequestBody CustomerDTO customerDto) {

		boolean updated = false;

		updated = accountsService.updateAccountDetails(customerDto);

		if (updated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDTO(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
		} else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
					.body(new ResponseDTO(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_UPDATE));
		}

	}

	@Operation(
			summary="DELETE Account and Customer Details REST API",
			description = "REST API to delete customer and account details using a mobile number"
			)
	@ApiResponses({
		@ApiResponse(
				responseCode = "200",
				description = "HttpStatus 200 OK"),
		@ApiResponse(
				responseCode = "417",
				description = "Expectation Failed"
				)
		,
		@ApiResponse(
				responseCode = "500",
				description = "HttpStatus 500 Internal Server Error")
		
	})
	@DeleteMapping("/delete/{mobileNumber}")
	public ResponseEntity<ResponseDTO> deleteAccount(
			@Valid @PathVariable @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") String mobileNumber) {

		boolean updated = false;

		updated = accountsService.deleteAccount(mobileNumber);

		if (updated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDTO(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
		} else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
					.body(new ResponseDTO(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_DELETE));
		}

	}
}
