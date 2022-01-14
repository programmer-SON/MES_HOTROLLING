package com.poscoict.mes.process.order.controller;

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
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@PostMapping("/orders")
	public ResponseEntity<ResponseOrder> createOrders(@RequestBody RequestOrder requestOrder){
		
      ModelMapper mapper = new ModelMapper();
      mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        
       ResponseOrder responseOrder = mapper.map(requestOrder, ResponseOrder.class);
       
        //ResponseOrder responseUser = mapper.map(userDto, ResponseUser.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(responseOrder);
	}

	@GetMapping("/{userId}/plans")
	public ResponseEntity<ResponseProductPlan> getProductPlan(@PathVariable("userId") String userId){

		//ResponseProductPlan responseProductPlan = orderService.getProductPlan(userId);
		ResponseProductPlan responseProductPlan = orderService.getProductPlan(userId);

		return ResponseEntity.status(HttpStatus.OK).body(responseProductPlan);
	}
}
