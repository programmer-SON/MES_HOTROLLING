package com.poscoict.mes.process.product.controller;

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

import com.poscoict.mes.process.product.jpa.ProductLogEntity;
import com.poscoict.mes.process.product.jpa.ProductLogRepository;
import com.poscoict.mes.process.product.vo.ResponseProductLog;

@RestController
@RequestMapping("/process-service")
public class ProductController {
	
	ProductLogRepository productLogRepository;
	
	@Autowired
	public ProductController(ProductLogRepository productLogRepository) {
		this.productLogRepository = productLogRepository;
	}

	@GetMapping("/product_log")
	public ResponseEntity<List<ResponseProductLog>> getProductLog(){		
		Iterable<ProductLogEntity> productLogList = productLogRepository.findAll();
		List<ResponseProductLog> result = new ArrayList<>();
		
		productLogList.forEach(v -> {
			result.add(new ModelMapper().map(v, ResponseProductLog.class));
		});
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
}
