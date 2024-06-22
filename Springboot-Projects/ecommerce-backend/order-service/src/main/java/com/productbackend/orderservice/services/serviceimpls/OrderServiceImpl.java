package com.productbackend.orderservice.services.serviceimpls;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productbackend.orderservice.constants.OrderConstants;
import com.productbackend.orderservice.dtos.OrderDto;
import com.productbackend.orderservice.dtos.OrderResponseDto;
import com.productbackend.orderservice.entities.Order;
import com.productbackend.orderservice.exceptions.OrderNotFoundException;
import com.productbackend.orderservice.external.clients.PaymentService;
import com.productbackend.orderservice.external.clients.ProductService;
import com.productbackend.orderservice.external.requests.PaymentDto;
import com.productbackend.orderservice.external.response.PaymentResponseDto;
import com.productbackend.orderservice.external.response.ProductDto;
import com.productbackend.orderservice.repositories.OrderRepository;
import com.productbackend.orderservice.services.OrderService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public Long creteOrder(OrderDto orderDto) {

		log.info("Create Order ---------------> Entered");

		// Call the product service to block the products/reduce the product quantity
		productService.reduceProductQuantity(orderDto.getProductId(), orderDto.getQuantity());

		// Save the order data with Status Order Created
		Order orderEntity = Order.builder().productId(orderDto.getProductId()).quantity(orderDto.getQuantity())
				.orderAmount(orderDto.getOrderAmount()).orderStatus(OrderConstants.ORDER_CREATED)
				.orderDate(Instant.now()).build();

		orderRepository.save(orderEntity);

		log.info("Order created with order Id: " + orderEntity.getId());

		// Call the payment service for order success/failure

		PaymentDto paymentDto = PaymentDto.builder()
				.orderId(orderEntity.getId())
				.amount(orderEntity.getOrderAmount())
				.paymentMode(orderDto.getPaymentMode())
				.transactionNumber("4178651474")
				.build();
		log.info("Calling the payment service");

		boolean paymentSuccess = false;
		try {
			paymentService.makePayment(paymentDto);
			log.info("Payment Done successfully.");
			paymentSuccess = true;
		} catch (Exception e) {
			log.error("Error in payment service. Changing order status");
		}

		orderEntity.setOrderStatus(paymentSuccess ? OrderConstants.ORDER_PLACED : OrderConstants.PAYMENT_FAILED);

		orderRepository.save(orderEntity);
		
		log.info("Create Order ---------------> Exit");

		return orderEntity.getId();
	}

	@Override
	public OrderResponseDto getOrderDetailsById(long orderId) {
		log.info("Getting Order details by order Id");

		Order orderEntity = orderRepository.findById(orderId)
				.orElseThrow(() -> new OrderNotFoundException(OrderConstants.ORDER_NOT_FOUND_MESSAGE + orderId));
		
		log.info("Calling Product service to get Product details by Product Id: {}", orderEntity.getProductId());
		ProductDto productDto = objectMapper.convertValue(productService.getProductById(orderEntity.getProductId()).getBody(), ProductDto.class);
		
		log.info("Calling Payment service to get Payment details by Order Id: {}", orderId);
		PaymentResponseDto paymentDetails = objectMapper.convertValue(paymentService.getPaymentDetailsByOrderId(orderId).getBody(), PaymentResponseDto.class);
		
		return OrderResponseDto.builder()
				.id(orderEntity.getId())
				.productId(orderEntity.getProductId())
				.quantity(orderEntity.getQuantity())
				.orderAmount(orderEntity.getOrderAmount())
				.productDetails(productDto)
				.paymentDetails(paymentDetails)
				.build();
	}

}
