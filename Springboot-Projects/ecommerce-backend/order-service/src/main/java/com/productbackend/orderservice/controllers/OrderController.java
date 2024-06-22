package com.productbackend.orderservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productbackend.orderservice.dtos.OrderDto;
import com.productbackend.orderservice.services.OrderService;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping(value = "/createOrder")
	public ResponseEntity<Object> createOrder(OrderDto orderDto){
		
		return new ResponseEntity<>(orderService.creteOrder(orderDto), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{orderId}")
	public ResponseEntity<Object> getOrderDetailsById(@PathVariable("orderId") long orderId){
		return new ResponseEntity<>(orderService.getOrderDetailsById(orderId), HttpStatus.OK);
	}
}
