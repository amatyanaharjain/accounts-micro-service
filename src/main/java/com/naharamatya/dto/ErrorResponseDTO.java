package com.naharamatya.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
		name="Error Response",description = "Schema to hold error response Information")
public class ErrorResponseDTO {

	@Schema(
			description = "API path invoked by client"
			)
	private String apiPath;
	
	@Schema(
			description = "Error code representing the error"
			)
	private HttpStatus errorCode;
	
	@Schema(
			description = "Error message representing the error"
			)
	private String errorMessage;
	
	@Schema(
			description = "Time representing when the error happenned"
			)
	private LocalDateTime errorTime;
}
