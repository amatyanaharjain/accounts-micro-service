package com.naharamatya.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
		name="CUSTOMER",
		description = "Schema to hold customer and account information")
public class CustomerDTO {

	@Schema(
			description = "Name of the customer", example = "John Doe"
			)
	@NotEmpty(message = "name can not be a null or empty")
	@Size(min = 5,max = 30, message="The length of the customer name should be between 5 and 30")
	private String name;

	@Schema(
			description = "Email address of the customer", example = "example@gmail.com"
			)
	@NotEmpty(message = "email address can not be a null or empty")
	@Email(message="email address should be a valid value")
	private String email;

	@Schema(
			description = "Mobile number of the customer", example = "9876543210"
			)
	@NotEmpty(message = "mobile number can not be a null or empty")
	@Pattern(regexp="(^$|[0-9]{10})", message="Mobile number must be 10 digits")
	private String mobileNumber;
	
	@Schema(
			description = "Accounts details of the customer"
			)
	private AccountsDTO accountsDto;
}
