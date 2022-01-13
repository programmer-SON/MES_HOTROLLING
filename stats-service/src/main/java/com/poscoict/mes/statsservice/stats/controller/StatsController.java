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

import com.poscoict.mes.statsservice.stats.jpa.TempStatsLogEntity;
import com.poscoict.mes.statsservice.stats.jpa.TempStatsLogRepository;
import com.poscoict.mes.statsservice.stats.vo.ResponseTempStatsLog;

@RestController
@RequestMapping("/stats-service")
public class StatsController {
	
	TempStatsLogRepository tempStatsLogRepository;

	@Autowired
	public StatsController(TempStatsLogRepository tempStatsLogRepository) {
		this.tempStatsLogRepository = tempStatsLogRepository;
	}

	@GetMapping("/temperature_stats_log")
	public ResponseEntity<List<ResponseTempStatsLog>> getStatsLog(){		
		Iterable<TempStatsLogEntity> tempStatsLogList = tempStatsLogRepository.findAll();
		List<ResponseTempStatsLog> result = new ArrayList<>();
		
		tempStatsLogList.forEach(v -> {
			result.add(new ModelMapper().map(v, ResponseTempStatsLog.class));
		});
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
}
