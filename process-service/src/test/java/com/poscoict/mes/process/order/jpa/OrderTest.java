package com.poscoict.mes.process.order.jpa;

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
class OrderTest {

	@Autowired
	OrderRepository repo;
	
	@Test
	@DisplayName("insertOrder")
	void insertOrder() {
		
		IntStream.range(1, 10).forEach(i -> {
			OrderEntity entity = new OrderEntity();
			entity.setOrderId("A1234" + i);
			entity.setProductId("B1234" + i);
			entity.setProcessStart(new Date());
			entity.setProcessEnd(new Date());
			entity.setProductId("C1234"+i);
			entity.setUserId("D1234"+i);
			entity.setStockPlan(200);
			if(i % 2 == 0) {
				entity.setStatus("진행중");
			}else {
				entity.setStatus("완료");
			}
			repo.save(entity);
		});	
	}
	
	@Test
	void getOrders() {}

}
