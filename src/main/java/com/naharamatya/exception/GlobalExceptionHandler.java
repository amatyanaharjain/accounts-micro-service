package com.naharamatya.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.naharamatya.dto.ErrorResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(CustomerAlreadyExistException.class)
	public ResponseEntity<ErrorResponseDTO> handleCustomerAlreadyExistsException(CustomerAlreadyExistException exception, WebRequest webRequest)
	{
		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(webRequest.getDescription(false), 
				HttpStatus.BAD_REQUEST, exception.getMessage(), LocalDateTime.now());
		
		return new ResponseEntity<>(errorResponseDTO,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest)
	{
		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(webRequest.getDescription(false), 
				HttpStatus.NOT_FOUND, exception.getMessage(), LocalDateTime.now());
		
		return new ResponseEntity<>(errorResponseDTO,HttpStatus.NOT_FOUND);
	}
}
