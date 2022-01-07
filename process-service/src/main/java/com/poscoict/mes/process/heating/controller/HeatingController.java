package com.poscoict.mes.process.heating.controller;

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

import com.poscoict.mes.process.heating.jpa.HeatingLogEntity;
import com.poscoict.mes.process.heating.jpa.HeatingLogRepository;
import com.poscoict.mes.process.heating.vo.ResponseHeatingLog;

@RestController
@RequestMapping("/process-service")
public class HeatingController {
	
	HeatingLogRepository heatingLogRepository;
	
	@Autowired
	public HeatingController(HeatingLogRepository heatingLogRepository) {
		this.heatingLogRepository = heatingLogRepository;
	}

	@GetMapping("/heating_furnance_temperature_log")
	public ResponseEntity<List<ResponseHeatingLog>> getHeatingLog(){		
		Iterable<HeatingLogEntity> heatingLogList = heatingLogRepository.findAll();
		List<ResponseHeatingLog> result = new ArrayList<>();
		
		heatingLogList.forEach(v -> {
			result.add(new ModelMapper().map(v, ResponseHeatingLog.class));
		});
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
}
