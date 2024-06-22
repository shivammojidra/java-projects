package com.productbackend.paymentservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.productbackend.paymentservice.constants.PaymentConstants;
import com.productbackend.paymentservice.dtos.ExceptionDto;

@ControllerAdvice
@ResponseBody
public class PaymentResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(PaymentDetailsNotFoundException.class)
	public ResponseEntity<Object> handlePaymentDetailsNotFoundException(PaymentDetailsNotFoundException exception){
		ExceptionDto exceptionDto = ExceptionDto.builder()
				.message(exception.getMessage())
				.description(PaymentConstants.GENERIC_DESCRIPTION_NOT_FOUND)
				.errorCode(PaymentConstants.ERROR_NOT_FOUND)
				.build();
		return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGenericException(Exception exception){
		ExceptionDto exceptionDto = ExceptionDto.builder()
				.message(exception.getMessage())
				.description(PaymentConstants.INTERNAL_SERVER_ERROR_DESCRIPTION)
				.errorCode(PaymentConstants.ERROR_INTERNAL_SERVER_ERROR)
				.build();
		return new ResponseEntity<>(exceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
