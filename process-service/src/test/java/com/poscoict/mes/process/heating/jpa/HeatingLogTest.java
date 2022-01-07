package com.poscoict.mes.process.heating.jpa;

import java.util.Date;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class HeatingLogTest {

	@Autowired
	HeatingLogRepository repo;
	
	@Test
	@DisplayName("insertHeatingLog")
	void insertHeatingLog() {
		IntStream.range(1, 10).forEach(i -> {
			HeatingLogEntity entity = new HeatingLogEntity();
			entity.setHeating_furnance_id(i);
			entity.setHeating_zone_temp(i*0.1);
			entity.setPreheating_zone_temp(i*0.01);
			entity.setSoaking_zone_temp(i * 0.001);
			entity.setHeating_furnance_update(new Date());
			
			repo.save(entity);
		});	
	}
	
	@Test
	void getHeatingLog() {}

}
