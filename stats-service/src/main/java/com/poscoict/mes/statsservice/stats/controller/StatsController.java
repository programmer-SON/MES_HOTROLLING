package com.poscoict.mes.statsservice.stats.controller;

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

import com.poscoict.mes.statsservice.stats.jpa.ProductStatsLogEntity;
import com.poscoict.mes.statsservice.stats.jpa.ProductStatsLogRepository;
import com.poscoict.mes.statsservice.stats.jpa.StockStatsLogEntity;
import com.poscoict.mes.statsservice.stats.jpa.StockStatsLogRepository;
import com.poscoict.mes.statsservice.stats.jpa.TempStatsLogEntity;
import com.poscoict.mes.statsservice.stats.jpa.TempStatsLogRepository;
import com.poscoict.mes.statsservice.stats.vo.ResponseProductStatsLog;
import com.poscoict.mes.statsservice.stats.vo.ResponseStockStatsLog;
import com.poscoict.mes.statsservice.stats.vo.ResponseTempStatsLog;

@RestController
@RequestMapping("/stats-service")
public class StatsController {
	
	TempStatsLogRepository tempStatsLogRepository;
	StockStatsLogRepository stockStatsLogRepository;
	ProductStatsLogRepository productStatsLogRepository;

	@Autowired
	public StatsController(TempStatsLogRepository tempStatsLogRepository,
			StockStatsLogRepository stockStatsLogRepository,
			ProductStatsLogRepository productStatsLogRepository) {
		this.tempStatsLogRepository = tempStatsLogRepository;
		this.stockStatsLogRepository = stockStatsLogRepository;
		this.productStatsLogRepository = productStatsLogRepository;
	}

	@GetMapping("/heating_furnance_temperature_log")
	public ResponseEntity<List<ResponseTempStatsLog>> getTempStatsLog(){		
		Iterable<TempStatsLogEntity> tempStatsLogList = tempStatsLogRepository.findAll();
		List<ResponseTempStatsLog> result = new ArrayList<>();
		
		tempStatsLogList.forEach(v -> {
			result.add(new ModelMapper().map(v, ResponseTempStatsLog.class));
		});
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@GetMapping("/stock_stats_log")
	public ResponseEntity<List<ResponseStockStatsLog>> getStockStatsLog(){		
		Iterable<StockStatsLogEntity> stockStatsLogList = stockStatsLogRepository.findAll();
		List<ResponseStockStatsLog> result = new ArrayList<>();
		
		stockStatsLogList.forEach(v -> {
			result.add(new ModelMapper().map(v, ResponseStockStatsLog.class));
		});
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@GetMapping("/product_log")
	public ResponseEntity<List<ResponseProductStatsLog>> getProductStatsLog(){		
		Iterable<ProductStatsLogEntity> productStatsLogList = productStatsLogRepository.findAll();
		List<ResponseProductStatsLog> result = new ArrayList<>();
		
		productStatsLogList.forEach(v -> {
			result.add(new ModelMapper().map(v, ResponseProductStatsLog.class));
		});
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
}
