package com.productbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productbackend.dtos.ProductDto;
import com.productbackend.service.ProductService;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@PostMapping(value = "/add")
	public ResponseEntity<Object> addProduct(@RequestBody ProductDto product){
		return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getById/{productId}")
	public ResponseEntity<Object> getProductById(@PathVariable("productId") Long productId){
		return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<Object> getAllProducts(){
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}
	
	@PutMapping(value = "/reduceQuantity/{productId}/{productQuantity}")
	public ResponseEntity<Void> reduceProductQuantity(@PathVariable("productId") Long productId,
			@PathVariable("productQuantity") Long productQuantity) {
		productService.reduceProductQuantity(productId, productQuantity);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
