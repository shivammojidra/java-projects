package com.productbackend.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
	
	private long id;
	private String name;
	private long price;
	private long quantity;
}
