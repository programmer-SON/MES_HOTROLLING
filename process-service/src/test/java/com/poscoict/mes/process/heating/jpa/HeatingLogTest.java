package com.poscoict.mes.process.heating.jpa;

import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HeatingLogTest {

	@Autowired
	HeatingLogRepository repo;
	
	@Test
	@DisplayName("insertHeatingLog")
	void insertHeatingLog() {
		IntStream.range(1, 20).forEach(j -> {
			IntStream.range(1, 5).forEach(i -> {
				HeatingLogEntity entity = new HeatingLogEntity();
				entity.setHeatingFurnanceId("hotRolling" + i);
				entity.setPreheatingZoneTemp(900 + i*10 + j);
			
				if(i % 2 == 0) {
					entity.setHeatingZoneTemp(700 + i*10 - j);
					entity.setSoakingZoneTemp(1000 - i*10 + j);
				}else {
					entity.setHeatingZoneTemp(700 - i*10 + j);
					entity.setSoakingZoneTemp(1000 + i*10 - j);
				}
			
				entity.setHeatingFurnanceUpdate("2022-01-"+j);
			
				repo.save(entity);
			});
		});
	}
	
	@Test
	void getHeatingLog() {}

}
