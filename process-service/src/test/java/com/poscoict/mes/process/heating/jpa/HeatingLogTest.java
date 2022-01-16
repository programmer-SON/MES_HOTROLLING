package com.poscoict.mes.process.heating.jpa;

import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
// @RunWith(SpringRunner.class)
class HeatingLogTest {

	@Autowired
	HeatingLogRepository repo;
	
	@Test
	@DisplayName("insertHeatingLog")
	void insertHeatingLog() {
		IntStream.range(1, 10).forEach(i -> {
			HeatingLogEntity entity = new HeatingLogEntity();
			entity.setHeatingFurnanceId("id"+i);
			entity.setHeatingZoneTemp(i*10);
			entity.setPreheatingZoneTemp(i*20);
			entity.setSoakingZoneTemp(i * 30);
			entity.setHeatingFurnanceUpdate("2022-01-"+i);
			
			repo.save(entity);
		});	
	}
	
	@Test
	void getHeatingLog() {}

}
