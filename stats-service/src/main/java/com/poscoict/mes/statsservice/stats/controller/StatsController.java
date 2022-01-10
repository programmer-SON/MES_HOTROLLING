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

import com.poscoict.mes.statsservice.stats.jpa.StatsLogEntity;
import com.poscoict.mes.statsservice.stats.jpa.StatsLogRepository;
import com.poscoict.mes.statsservice.stats.vo.ResponseStatsLog;

@RestController
@RequestMapping("/stats-service")
public class StatsController {
	
	StatsLogRepository statsLogRepository;

	@Autowired
	public StatsController(StatsLogRepository statsLogRepository) {
		this.statsLogRepository = statsLogRepository;
	}

	@GetMapping("/stats_log")
	public ResponseEntity<List<ResponseStatsLog>> getStatsLog(){		
		Iterable<StatsLogEntity> statsLogList = statsLogRepository.findAll();
		List<ResponseStatsLog> result = new ArrayList<>();
		
		statsLogList.forEach(v -> {
			result.add(new ModelMapper().map(v, ResponseStatsLog.class));
		});
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
}
