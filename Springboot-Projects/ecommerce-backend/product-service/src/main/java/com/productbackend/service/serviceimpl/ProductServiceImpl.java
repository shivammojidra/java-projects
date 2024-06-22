package com.productbackend.service.serviceimpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productbackend.constants.ProductConstants;
import com.productbackend.dtos.ProductDto;
import com.productbackend.entities.Product;
import com.productbackend.exceptions.ProductNotFoundException;
import com.productbackend.exceptions.ProductQuantityException;
import com.productbackend.repositories.ProductRepository;
import com.productbackend.service.ProductService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Long addProduct(ProductDto productDto) {
		log.info("Creating product");
		Product productEntity = Product.builder()
				.name(productDto.getName())
				.price(productDto.getPrice())
				.quantity(productDto.getQuantity())
				.build();
		
		productRepository.save(productEntity);
		return productEntity.getId();
	}

	@Override
	public ProductDto getProductById(Long productId) {
		log.info("Get Product By Id");
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException(ProductConstants.PRODUCT_NOT_FOUND_MESSAGE + productId));
		ProductDto productDto = ProductDto.builder().build();
		BeanUtils.copyProperties(product, productDto);
		return productDto;
	}

	@Override
	public List<ProductDto> getAllProducts() {
		log.info("Get All Products");
		return productRepository.findAll().stream().map(productEntity -> {
			ProductDto productDto = ProductDto.builder().build();
			BeanUtils.copyProperties(productEntity, productDto);
			return productDto;
		}).toList();
	}

	@Override
	public void reduceProductQuantity(Long productId, Long productQuantity) {
		log.info("Reduce Product Quantity - Product Id: " + productId);
		Product product = productRepository.findById(productId).orElseThrow(
				() -> new ProductNotFoundException(ProductConstants.PRODUCT_NOT_FOUND_MESSAGE + productId));

		if (product.getQuantity() < productQuantity) {
			throw new ProductQuantityException(ProductConstants.PRODUCT_INSUFFICIENT_QUANTITY_MESSAGE + product.getQuantity());
		}

		product.setQuantity(product.getQuantity() - productQuantity);
		productRepository.save(product);
		log.info("Product Quantity reduced Successfully");
	}

}
