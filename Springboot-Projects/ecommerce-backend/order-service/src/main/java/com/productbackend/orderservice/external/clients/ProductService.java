package com.productbackend.orderservice.external.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("product-service/v1/product")
public interface ProductService {
	
	@PutMapping(value = "/reduceQuantity/{productId}/{productQuantity}")
	ResponseEntity<Void> reduceProductQuantity(@PathVariable("productId") Long productId,
			@PathVariable("productQuantity") Long productQuantity);
	
	@GetMapping(value = "/getById/{productId}")
	public ResponseEntity<Object> getProductById(@PathVariable("productId") Long productId);
}
