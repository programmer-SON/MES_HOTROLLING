package com.poscoict.mes.process.product.jpa;

import java.util.Random;
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
Random random = new Random();
		
		IntStream.range(1, 6).forEach(i -> {
			
			switch(i){
			case 1:
				IntStream.range(1, 20).forEach(j -> {
					ProductLogEntity entity = new ProductLogEntity();
					entity.setProductId("ANCOR-C");
					
					if(random.nextInt(100)%2 == 0) {
						entity.setThickness(2.0 + i*0.1);
						entity.setWidth(1500 + i*11 - j);
						entity.setLength(1100+i);
						entity.setProductStatus("양품");
						entity.setProductUpdate("2022-01-"+j);
					}else {
						entity.setThickness(2.0 - i*0.1);
						entity.setWidth(1500 - i*11 + j);
						entity.setLength(1100-i);
						entity.setProductStatus("불량");
						entity.setProductUpdate("2022-01-"+j);
					}
					repo.save(entity);
				});
				break;
			case 2:
				IntStream.range(1, 20).forEach(j -> {
					ProductLogEntity entity = new ProductLogEntity();
					entity.setProductId("ANCOR-H");
					
					if(random.nextInt(100)%2 == 0) {
						entity.setThickness(6.0 + i*0.1);
						entity.setWidth(1500 + i*11 - j);
						entity.setLength(370+i);
						entity.setProductStatus("양품");
						entity.setProductUpdate("2022-01-"+j);
					}else {
						entity.setThickness(6.0 - i*0.1);
						entity.setWidth(1500 - i*11 + j);
						entity.setLength(370-i);
						entity.setProductStatus("불량");
						entity.setProductUpdate("2022-01-"+j);
					}
					repo.save(entity);
				});
				break;
			case 3:
				IntStream.range(1, 20).forEach(j -> {
					ProductLogEntity entity = new ProductLogEntity();
					entity.setProductId("JS-SECC");
					
					if(random.nextInt(100)%2 == 0) {
						entity.setThickness(5.0 + i*0.1);
						entity.setWidth(1200 + i*11 - j);
						entity.setLength(540+i);
						entity.setProductStatus("양품");
						entity.setProductUpdate("2022-01-"+j);
					}else {
						entity.setThickness(5.0 - i*0.1);
						entity.setWidth(1200 - i*11 + j);
						entity.setLength(540-i);
						entity.setProductStatus("불량");
						entity.setProductUpdate("2022-01-"+j);
					}
					repo.save(entity);
				});
				break;
			case 4:
				IntStream.range(1, 20).forEach(j -> {
					ProductLogEntity entity = new ProductLogEntity();
					entity.setProductId("SAE1070");
					
					if(random.nextInt(100)%2 == 0) {
						entity.setThickness(4.8 + i*0.1);
						entity.setWidth(1200 + i*11 - j);
						entity.setLength(540+i);
						entity.setProductStatus("양품");
						entity.setProductUpdate("2022-01-"+j);
					}else {
						entity.setThickness(4.8 - i*0.1);
						entity.setWidth(1200 - i*11 + j);
						entity.setLength(540-i);
						entity.setProductStatus("불량");
						entity.setProductUpdate("2022-01-"+j);
					}
					repo.save(entity);
				});
				break;
			case 5:
				IntStream.range(1, 20).forEach(j -> {
					ProductLogEntity entity = new ProductLogEntity();
					entity.setProductId("KS-SECC");
					
					if(random.nextInt(100)%2 == 0) {
						entity.setThickness(4.8 + i*0.1);
						entity.setWidth(1200 + i*11 - j);
						entity.setLength(11+i);
						entity.setProductStatus("양품");
						entity.setProductUpdate("2022-01-"+j);
					}else {
						entity.setThickness(4.8 - i*0.1);
						entity.setWidth(1200 - i*11 + j);
						entity.setLength(11-i);
						entity.setProductStatus("불량");
						entity.setProductUpdate("2022-01-"+j);
					}
					repo.save(entity);
				});
				break;
			}
		});
	}
	
	@Test
	void getProductLog() {}

}
