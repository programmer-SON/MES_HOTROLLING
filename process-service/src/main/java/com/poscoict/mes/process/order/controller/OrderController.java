package com.poscoict.mes.process.order.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poscoict.mes.process.order.jpa.OrderEntity;
import com.poscoict.mes.process.order.jpa.OrderRepository;
import com.poscoict.mes.process.order.vo.ResponseOrder;

@RestController
@RequestMapping("/process-service")
public class OrderController {
	
	OrderRepository orderRepository;
	
	
	@Autowired
	public OrderController(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}


	@GetMapping("/orders")
	public ResponseEntity<List<ResponseOrder>> getOrders(){
		
		Iterable<OrderEntity> orderList = orderRepository.findAll();
		
		List<ResponseOrder> result = new ArrayList<>();
		
		orderList.forEach(v -> {
			result.add(new ModelMapper().map(v, ResponseOrder.class));
		});
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
