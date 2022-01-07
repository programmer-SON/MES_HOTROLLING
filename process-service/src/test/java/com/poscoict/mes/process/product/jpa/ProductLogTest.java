package com.poscoict.mes.process.product.jpa;

import java.time.LocalTime;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class ProductLogTest {

	@Autowired
	ProductLogRepository repo;
	
	@Test
	@DisplayName("insertOrder")
	void insertProductLog() {
		IntStream.range(1, 10).forEach(i -> {
			ProductLogEntity entity = new ProductLogEntity();
			entity.setProduct_id("B1234" + i);
			entity.setThickness(i*10);
			entity.setWidth(i*100);
			entity.setLength(i*5);
			entity.setProduct_update(LocalTime.now());
			
			if(i % 2 == 0) {
				entity.setProduct_status("정상");
			}else {
				entity.setProduct_status("불량");
			}
			repo.save(entity);
		});	
	}
	
	@Test
	void getProductLog() {}

}
