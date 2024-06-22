package com.productbackend.orderservice.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.productbackend.orderservice.constants.OrderConstants;
import com.productbackend.orderservice.exceptions.OrderNotFoundException;
import com.productbackend.orderservice.exceptions.ProductNotFoundException;
import com.productbackend.orderservice.exceptions.ProductQuantityException;
import com.productbackend.orderservice.external.response.ExceptionDto;


@ControllerAdvice
@ResponseBody
public class RestResponeExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException exception){
		ExceptionDto exceptionDto = ExceptionDto.builder()
				.message(exception.getMessage())
				.description(OrderConstants.PRODUCT_NOT_FOUND_DESCRIPTION)
				.errorCode(OrderConstants.ERROR_NOT_FOUND)
				.build();
		return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductQuantityException.class)
	public ResponseEntity<Object> handleProductQuantityException(ProductQuantityException exception){
		ExceptionDto exceptionDto = ExceptionDto.builder()
				.message(exception.getMessage())
				.description(OrderConstants.INSUFFICIENT_PRODUCT_QUANTITY_DESCRIPTION)
				.errorCode(OrderConstants.ERROR_INSUFFICIENT_QUANTITY)
				.build();
		return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<Object> handleOrderNotFoundException(OrderNotFoundException exception){
		ExceptionDto exceptionDto = ExceptionDto.builder()
				.message(exception.getMessage())
				.description(OrderConstants.GENERIC_DESCRIPTION_NOT_FOUND)
				.errorCode(OrderConstants.ERROR_NOT_FOUND)
				.build();
		return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGenericException(Exception exception){
		ExceptionDto exceptionDto = ExceptionDto.builder()
				.message(exception.getMessage())
				.description(OrderConstants.INTERNAL_SERVER_ERROR_DESCRIPTION)
				.errorCode(OrderConstants.ERROR_INTERNAL_SERVER_ERROR)
				.build();
		return new ResponseEntity<>(exceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
