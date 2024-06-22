package com.productbackend.service;

import java.util.List;

import com.productbackend.dtos.ProductDto;

public interface ProductService {

	Long addProduct(ProductDto productDto);

	ProductDto getProductById(Long productId);

	List<ProductDto> getAllProducts();

	void reduceProductQuantity(Long productId, Long productQuantity);

}
