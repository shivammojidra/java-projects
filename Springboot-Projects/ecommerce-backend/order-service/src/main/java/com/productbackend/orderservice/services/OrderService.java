package com.productbackend.orderservice.services;

import com.productbackend.orderservice.dtos.OrderDto;
import com.productbackend.orderservice.dtos.OrderResponseDto;

public interface OrderService {

	Long creteOrder(OrderDto orderDto);

	OrderResponseDto getOrderDetailsById(long orderId);

}
