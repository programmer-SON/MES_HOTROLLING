package com.poscoict.mes.user;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poscoict.mes.user.jpa.UserEntity;
import com.poscoict.mes.user.jpa.UserRepository;


@SpringBootTest
@RunWith(SpringRunner.class)
class UserServiceApplicationTests {


	@Test
	void contextLoads() {
	}
	
	@Autowired
	private UserRepository repo;
	
	
	@Test
	void testInsertUserTest() {
		UserEntity userEntity = new UserEntity();
		userEntity.setName("SON");
		userEntity.setPassword("1234");
		userEntity.setPhone(12345);
		userEntity.setEmail("son@naver.com");
		repo.save(userEntity);
		System.out.println("hello world");
	}

}
