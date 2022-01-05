package com.poscoict.mes.process.order.jpa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poscoict.mes.process.jpa.ProcessRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
class OrderTest {

	@Autowired
	OrderRepository repo;
		
//	@Autowired
//	public ProductTest(ProductRepository repo) {
//		this.repo = repo;
//	}

	
	@Test
	@DisplayName("insertOrder")
	void insertOrder() {
		
		IntStream.range(1, 10).forEach(i -> {
			OrderEntity entity = new OrderEntity();
			entity.setOrder_id("A1234" + i);
			entity.setProduct_id("B1234" + i);
			entity.setProcess_start(new Date());
			entity.setProcess_end(new Date());
			entity.setProduct_id("C1234"+i);
			entity.setUser_id("D1234"+i);
			entity.setStock_plan(200);
			if(i % 2 == 0) {
				entity.setStatus("진행중");
			}else {
				entity.setStatus("완료");
			}
			repo.save(entity);
		});
		
	}
	
	
	@Test
	void getOrders() {
		
	}
	
	
//	@Test
//	void getTestProduct() {
//		
//		System.out.println("hello Test");
//	}

}
