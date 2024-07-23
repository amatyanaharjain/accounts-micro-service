package com.naharamatya.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDTO {

	@NotEmpty(message = "account number can not be a null or empty")
	@Pattern(regexp="(^$|[0-9]{10})", message="Account number must be 10 digits")
	private Long accountNo;
	
	@NotEmpty(message = "account type can not be a null or empty")
	private String account_type;
	
	@NotEmpty(message = "branch address can not be a null or empty")
	private String branch_address;
}
