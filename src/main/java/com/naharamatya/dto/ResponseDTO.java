package com.naharamatya.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
		name="RESPONSE", description="Schema to hold successful response information"
		)
public class ResponseDTO {
	
	@Schema(
			description = "Status code in the response")
	private String statusCode;
	@Schema(
			description = "Status Message in the response")
	
	private String statusMessage;
}
