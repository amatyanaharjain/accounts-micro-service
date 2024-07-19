package com.naharamatya.mapper;

import com.naharamatya.dto.CustomerDTO;
import com.naharamatya.entity.Customer;

public class CustomerMapper {

	public static CustomerDTO mapToCustomerDto(Customer customer,CustomerDTO customerDto) {
		customerDto.setName(customer.getName());
		customerDto.setEmail(customer.getEmail());
		customerDto.setMobileNumber(customer.getMobileNumber());
		return customerDto;		
	}
	
	public static Customer mapToCustomer(CustomerDTO customerDto,Customer customer) {
		customer.setName(customerDto.getName());
		customer.setEmail(customerDto.getEmail());
		customer.setMobileNumber(customerDto.getMobileNumber());
		return customer;		
	}
	
	
}
