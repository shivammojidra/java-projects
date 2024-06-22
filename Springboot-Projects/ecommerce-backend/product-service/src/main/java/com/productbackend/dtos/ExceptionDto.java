package com.productbackend.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionDto {

	private String message;
	private String description;
	private String errorCode;
}
