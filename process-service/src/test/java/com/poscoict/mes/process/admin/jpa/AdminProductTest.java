package com.poscoict.mes.process.admin.jpa;

import java.util.Date;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminProductTest {

	@Autowired
	AdminProductRepository repo;
	
	@Test
	@DisplayName("insertAdminProduct")
	void insertAdminProduct() {
		IntStream.range(1, 10).forEach(i -> {
			AdminProductEntity entity = new AdminProductEntity();
			entity.setProductId("PB123" + i + "A");
			entity.setProductLen(i*10);
			entity.setProductWidth(i+100);
			entity.setProductThick(i*70);
			entity.setProductUpdate(new Date());
			
			repo.save(entity);
		});	
	}
	
	@Test
	void getHAdminProduct() {}

}
