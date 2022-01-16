package com.poscoict.mes.process.product.jpa;

import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductLogTest {

	@Autowired
	ProductLogRepository repo;
	
	@Test
	@DisplayName("insertProductLog")
	void insertProductLog() {
		IntStream.range(1, 10).forEach(i -> {
			ProductLogEntity entity = new ProductLogEntity();
			entity.setProductId("B1234" + i);
			entity.setThickness(i*10+0.1);
			entity.setWidth(i*100);
			entity.setLength(i*5);
			entity.setProductUpdate("i");
			
			if(i % 2 == 0) {
				entity.setProductStatus("정상");
			}else {
				entity.setProductStatus("불량");
			}
			repo.save(entity);
		});	
	}
	
	@Test
	void getProductLog() {}

}
