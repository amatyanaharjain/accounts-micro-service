package com.naharamatya.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDTO {

	private Long accountNo;
	
	private String account_type;
	
	private String branch_address;
}
