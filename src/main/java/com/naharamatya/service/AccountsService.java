package com.naharamatya.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naharamatya.constants.AccountsConstants;
import com.naharamatya.dto.AccountsDTO;
import com.naharamatya.dto.CustomerDTO;
import com.naharamatya.entity.Accounts;
import com.naharamatya.entity.Customer;
import com.naharamatya.exception.CustomerAlreadyExistException;
import com.naharamatya.exception.ResourceNotFoundException;
import com.naharamatya.mapper.AccountsMapper;
import com.naharamatya.mapper.CustomerMapper;
import com.naharamatya.repository.AccountsRepository;
import com.naharamatya.repository.CustomerRepository;

@Service
public class AccountsService {
	
	@Autowired
	private AccountsRepository accountsRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public void createAccount(CustomerDTO customerDto) {
		Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
		Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customer.getMobileNumber());
		
		if(optionalCustomer.isPresent()) {
			throw new CustomerAlreadyExistException("Customer already exists having mobile number " + customer.getMobileNumber() );
		}
		customer.setCreatedAt(LocalDateTime.now());
		customer.setCreatedBy("Anonymous");
		Customer savedCustomer = customerRepository.save(customer);
		
		accountsRepository.save(createNewAccount(savedCustomer.getCustomerId()));
	}

	private Accounts createNewAccount(Long customerId) {
		Accounts newAccount = new Accounts();
		newAccount.setCustomerId(customerId);
		long randomAccountNumber = 1000000000L + new Random().nextInt(900000000);
		
		newAccount.setAccountNo(randomAccountNumber);
		newAccount.setAccount_type(AccountsConstants.SAVINGS);
		newAccount.setBranch_address(AccountsConstants.ADDRESS);
		newAccount.setCreatedAt(LocalDateTime.now());
		newAccount.setCreatedBy("Anonymous");
		return newAccount;
	}

	public CustomerDTO fetchAccountDetailsByMobileNumber(String mobileNumber) {
	
		CustomerDTO customerDto = new CustomerDTO();
		Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
				()-> new ResourceNotFoundException("Customer not found with mobileNumber " +mobileNumber)
				);
		
		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
				()-> new ResourceNotFoundException("Account not found with customer ID  " +customer.getCustomerId())
				);
		
		
		customerDto = CustomerMapper.mapToCustomerDto(customer, customerDto);
		AccountsDTO accountsDto = AccountsMapper.mapToAccountsDto(accounts, new AccountsDTO());
		customerDto.setAccountsDto(accountsDto);
		
		
		return customerDto;
	}

}
