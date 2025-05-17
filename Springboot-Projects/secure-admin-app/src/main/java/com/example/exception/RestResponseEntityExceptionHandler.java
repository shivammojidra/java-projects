package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.dto.CommonResponse;

@ControllerAdvice
@ResponseBody
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	public ResponseEntity<Object> handleException(Exception e) {
		
		// TODO: e.get message to be changed, only for demo - Not Good practice
		
		return new ResponseEntity<>(CommonResponse.builder()
				.responseMessage(e.getMessage())
				.build(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
