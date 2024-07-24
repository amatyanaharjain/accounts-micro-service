package com.naharamatya.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
		name="ACCOUNTS",
		description = "Schema to hold account information")
public class AccountsDTO {

	@NotEmpty(message = "account number can not be a null or empty")
	@Pattern(regexp="(^$|[0-9]{10})", message="Account number must be 10 digits")
	@Schema(
			description = "Account Number of the customer", example = "8234567654"
			)
	private Long accountNo;
	
	@NotEmpty(message = "account type can not be a null or empty")
	@Schema(
			description = "Account Type", example = "SAVINGS"
			)
	private String account_type;
	
	@NotEmpty(message = "branch address can not be a null or empty")
	@Schema(
			description = "BRANCH Address", example = "123, Port Blair, New York"
			)
	private String branch_address;
}
