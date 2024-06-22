package com.productbackend.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.productbackend.constants.ProductConstants;
import com.productbackend.dtos.ExceptionDto;
import com.productbackend.exceptions.ProductNotFoundException;
import com.productbackend.exceptions.ProductQuantityException;

@ControllerAdvice
@ResponseBody
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException exception){
		ExceptionDto exceptionDto = ExceptionDto.builder()
				.message(exception.getMessage())
				.description(ProductConstants.PRODUCT_NOT_FOUND_DESCRIPTION)
				.errorCode(ProductConstants.ERROR_PRODUCT_NOT_FOUND)
				.build();
		return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductQuantityException.class)
	public ResponseEntity<Object> handleProductQuantityException(ProductQuantityException exception){
		ExceptionDto exceptionDto = ExceptionDto.builder()
				.message(exception.getMessage())
				.description(ProductConstants.INSUFFICIENT_PRODUCT_QUANTITY_DESCRIPTION)
				.errorCode(ProductConstants.ERROR_INSUFFICIENT_QUANTITY)
				.build();
		return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGenericException(Exception exception){
		ExceptionDto exceptionDto = ExceptionDto.builder()
				.message(exception.getMessage())
				.description(ProductConstants.INTERNAL_SERVER_ERROR_DESCRIPTION)
				.errorCode(ProductConstants.ERROR_INTERNAL_SERVER_ERROR)
				.build();
		return new ResponseEntity<>(exceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
