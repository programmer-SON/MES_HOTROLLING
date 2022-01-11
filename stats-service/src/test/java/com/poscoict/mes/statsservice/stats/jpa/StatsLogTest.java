package com.poscoict.mes.statsservice.stats.jpa;

import java.time.LocalTime;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StatsLogTest {

	@Autowired
	StatsLogRepository repo;
	
	@Test
	@DisplayName("insertStatsLog")
	void insertStatsLog() {
		IntStream.range(1, 10).forEach(i -> {
			StatsLogEntity entity = new StatsLogEntity();
			entity.setStatsId("B1234" + i);
			entity.setThickness(i*100);
			entity.setWidth(i*70);
			entity.setLength(i*500);
			entity.setStatsUpdate(LocalTime.now());
			
			if(i % 2 == 0) {
				entity.setStatsStatus("정상");
			}else {
				entity.setStatsStatus("불량");
			}
			repo.save(entity);
		});	
	}
	
	@Test
	void getStatsLog() {}

}
