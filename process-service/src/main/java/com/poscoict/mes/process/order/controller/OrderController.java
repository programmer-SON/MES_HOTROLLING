package com.poscoict.mes.process.order.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.poscoict.mes.process.order.service.OrderService;
import com.poscoict.mes.process.order.vo.ResponseProductPlan;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.poscoict.mes.process.order.jpa.OrderEntity;
import com.poscoict.mes.process.order.jpa.OrderRepository;
import com.poscoict.mes.process.order.vo.RequestOrder;
import com.poscoict.mes.process.order.vo.ResponseOrder;

@RestController
@RequestMapping("/process-service")
public class OrderController {
	
	OrderRepository orderRepository;
	OrderService orderService;
//	CompanyService companyService;
//	ProductService productService;
//	UserServiceClient userServiceClient;

	@Autowired
	public OrderController(OrderRepository orderRepository, OrderService orderService) {
		this.orderRepository = orderRepository;
		this.orderService = orderService;
	}

	@GetMapping("/orders")
	public ResponseEntity<List<ResponseOrder>> getOrders(){		
		Iterable<OrderEntity> orderList = orderRepository.findAll();
		List<ResponseOrder> result = new ArrayList<>();
		
		orderList.forEach(v -> {
			result.add(new ModelMapper().map(v, ResponseOrder.class));
		});
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@PostMapping("/orders")
	public ResponseEntity<Integer> createOrders(@RequestBody RequestOrder requestOrder) throws ParseException {
		
      ModelMapper mapper = new ModelMapper();
      mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

	  orderService.createOrder(requestOrder);

		return ResponseEntity.status(HttpStatus.CREATED).body(201);
	}

	@GetMapping("/{userId}/plans")
	public ResponseEntity<ResponseProductPlan> getProductPlan(@PathVariable("userId") String userId){

		ResponseProductPlan responseProductPlan = orderService.getProductPlan(userId);

		return ResponseEntity.status(HttpStatus.OK).body(responseProductPlan);
	}
}
