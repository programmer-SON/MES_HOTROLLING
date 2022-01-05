package com.poscoict.mes.process.product.jpa;

import static org.junit.jupiter.api.Assertions.*;

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
import com.poscoict.mes.process.order.jpa.OrderRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
class ProductTest {

	@Autowired
	ProductRepository repo;
		
//	@Autowired
//	public ProductTest(ProductRepository repo) {
//		this.repo = repo;
//	}

	
//	@Test
//	@DisplayName("insertProduct")
//	void insertProduct() {
//		
//		IntStream.range(1, 10).forEach(i -> {
//			ProductEntity entity = new ProductEntity();
//			entity.setProduct_id("A"+i);
//			entity.setThickness(i*1000);
//			entity.setWidth(i*10);
//			entity.setLength(i * 100);
//			entity.setStock( (int)Math.random() * 10);
//			repo.save(entity);
//		});		
//	}
	
	
	@Test
	void getProduct() {
		Iterable<ProductEntity> list = repo.findAll();
		Iterator it =list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	
//	@Test
//	void getTestProduct() {
//		
//		System.out.println("hello Test");
//	}

}
