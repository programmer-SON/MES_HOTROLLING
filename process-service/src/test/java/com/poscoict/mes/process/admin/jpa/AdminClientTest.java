package com.poscoict.mes.process.admin.jpa;

import java.util.Date;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminClientTest {

	@Autowired
	AdminClientRepository repo;
	
	@Test
	@DisplayName("insertAdminClient")
	void insertAdminClient() {
		IntStream.range(1, 10).forEach(i -> {
			AdminClientEntity entity = new AdminClientEntity();
			entity.setClientId("Client" + i);
			entity.setClientName("Name"+i);
			entity.setClientEmail("client"+i+"@gmail.com");
			entity.setClientNumber("010-1234-567" + i);
			entity.setClientUpdate(new Date());
			
			repo.save(entity);
		});	
	}
	
	@Test
	void getHAdminClient() {}

}
