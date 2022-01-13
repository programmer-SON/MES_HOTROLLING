package com.poscoict.mes.statsservice.stats.jpa;

import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class StatsLogTest {

	@Autowired
	TempStatsLogRepository repoTemp;
	
	@Test
	@DisplayName("insertTempStatsLog")
	void insertTempStatsLog() {
		IntStream.range(1, 20).forEach(j -> {
			IntStream.range(1, 5).forEach(i -> {
				TempStatsLogEntity entity = new TempStatsLogEntity();
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
			
				repoTemp.save(entity);
			});
		});
	}
	
	@Test
	void getTempStatsLog() {}
	
	@Autowired
	StockStatsLogRepository repoStock;
	
	@Test
	@DisplayName("insertStockStatsLog")
	void insertStockStatsLog() {
		IntStream.range(1, 6).forEach(i -> {
			StockStatsLogEntity entity = new StockStatsLogEntity();
			
			switch(i){
			case 1:
				entity.setProductId("ANCOR-C");
				entity.setStockPlan(i*15);
				entity.setStock(i*12);
				entity.setMakingStock(i*15-i*12);
				break;
			case 2:
				entity.setProductId("ANCOR-H");
				entity.setStockPlan(i*15);
				entity.setStock(i*12);
				entity.setMakingStock(i*15-i*12);
				break;
			case 3:
				entity.setProductId("JS-SECC");
				entity.setStockPlan(i*15);
				entity.setStock(i*12);
				entity.setMakingStock(i*15-i*12);
				break;
			case 4:
				entity.setProductId("SAE1070");
				entity.setStockPlan(i*15);
				entity.setStock(i*12);
				entity.setMakingStock(i*15-i*12);
				break;
			case 5:
				entity.setProductId("KS-SECC");
				entity.setStockPlan(i*15);
				entity.setStock(i*12);
				entity.setMakingStock(i*15-i*12);
				break;
			}
			
			if(i%2 == 0) {
				entity.setStatus("완료");
			}else {
				entity.setStatus("생산 중");
			}
			
			repoStock.save(entity);
		});
	}
	
	@Test
	void getStockStatsLog() {}
	
	@Autowired
	ProductStatsLogRepository repoProduct;
	
	@Test
	@DisplayName("insertProductStatsLog")
	void insertProductStatsLog() {
		Random random = new Random();
		
		IntStream.range(1, 6).forEach(i -> {
			
			switch(i){
			case 1:
				IntStream.range(1, 20).forEach(j -> {
					ProductStatsLogEntity entity = new ProductStatsLogEntity();
					entity.setProductId("ANCOR-C");
					
					if(random.nextInt(100)%2 == 0) {
						entity.setThickness(2.0 + i*0.1);
						entity.setWidth(1500 + i*11 - j);
						entity.setLength(1100+i);
						entity.setStatus("양품");
					}else {
						entity.setThickness(2.0 - i*0.1);
						entity.setWidth(1500 - i*11 + j);
						entity.setLength(1100-i);
						entity.setStatus("불량");
					}
					repoProduct.save(entity);
				});
				break;
			case 2:
				IntStream.range(1, 20).forEach(j -> {
					ProductStatsLogEntity entity = new ProductStatsLogEntity();
					entity.setProductId("ANCOR-H");
					
					if(random.nextInt(100)%2 == 0) {
						entity.setThickness(6.0 + i*0.1);
						entity.setWidth(1500 + i*11 - j);
						entity.setLength(370+i);
						entity.setStatus("양품");
					}else {
						entity.setThickness(6.0 - i*0.1);
						entity.setWidth(1500 - i*11 + j);
						entity.setLength(370-i);
						entity.setStatus("불량");
					}
					repoProduct.save(entity);
				});
				break;
			case 3:
				IntStream.range(1, 20).forEach(j -> {
					ProductStatsLogEntity entity = new ProductStatsLogEntity();
					entity.setProductId("JS-SECC");
					
					if(random.nextInt(100)%2 == 0) {
						entity.setThickness(5.0 + i*0.1);
						entity.setWidth(1200 + i*11 - j);
						entity.setLength(540+i);
						entity.setStatus("양품");
					}else {
						entity.setThickness(5.0 - i*0.1);
						entity.setWidth(1200 - i*11 + j);
						entity.setLength(540-i);
						entity.setStatus("불량");
					}
					repoProduct.save(entity);
				});
				break;
			case 4:
				IntStream.range(1, 20).forEach(j -> {
					ProductStatsLogEntity entity = new ProductStatsLogEntity();
					entity.setProductId("SAE1070");
					
					if(random.nextInt(100)%2 == 0) {
						entity.setThickness(4.8 + i*0.1);
						entity.setWidth(1200 + i*11 - j);
						entity.setLength(540+i);
						entity.setStatus("양품");
					}else {
						entity.setThickness(4.8 - i*0.1);
						entity.setWidth(1200 - i*11 + j);
						entity.setLength(540-i);
						entity.setStatus("불량");
					}
					repoProduct.save(entity);
				});
				break;
			case 5:
				IntStream.range(1, 20).forEach(j -> {
					ProductStatsLogEntity entity = new ProductStatsLogEntity();
					entity.setProductId("KS-SECC");
					
					if(random.nextInt(100)%2 == 0) {
						entity.setThickness(4.8 + i*0.1);
						entity.setWidth(1200 + i*11 - j);
						entity.setLength(11+i);
						entity.setStatus("양품");
					}else {
						entity.setThickness(4.8 - i*0.1);
						entity.setWidth(1200 - i*11 + j);
						entity.setLength(11-i);
						entity.setStatus("불량");
					}
					repoProduct.save(entity);
				});
				break;
			}
		});
	}
	
	@Test
	void getProductStatsLog() {}

}
