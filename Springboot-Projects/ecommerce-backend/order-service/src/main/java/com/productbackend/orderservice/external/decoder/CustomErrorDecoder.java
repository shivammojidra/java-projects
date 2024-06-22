package com.productbackend.orderservice.external.decoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productbackend.orderservice.constants.OrderConstants;
import com.productbackend.orderservice.exceptions.GenericRuntimeException;
import com.productbackend.orderservice.exceptions.ProductNotFoundException;
import com.productbackend.orderservice.exceptions.ProductQuantityException;
import com.productbackend.orderservice.external.response.ExceptionDto;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CustomErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		ObjectMapper objectMapper = new ObjectMapper();
		
		log.info(":: {}", response.request().url());
		log.info(":: {}", response.request().headers());
		
		try {
			
			final String error = IOUtils.toString(response.body().asReader(StandardCharsets.UTF_8));
			ExceptionDto exceptionDto = objectMapper.readValue(error, ExceptionDto.class);
			if(exceptionDto.getErrorCode().equalsIgnoreCase(OrderConstants.ERROR_NOT_FOUND)) {
				return new ProductNotFoundException(exceptionDto.getMessage());
			}else if(exceptionDto.getErrorCode().equalsIgnoreCase(OrderConstants.ERROR_INSUFFICIENT_QUANTITY)) {
				return new ProductQuantityException(exceptionDto.getMessage());
			}else {
				return new GenericRuntimeException(exceptionDto.getMessage());
			}
		} catch (IOException e) {
			throw new GenericRuntimeException(OrderConstants.INTERNAL_SERVER_ERROR_MESSAGE);
		}
	}
}
