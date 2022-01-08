package com.poscoict.mes.user.jpa;


import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poscoict.mes.user.jpa.UserEntity;
import com.poscoict.mes.user.jpa.UserRepository;

@SpringBootTest
//@RunWith(SpringRunner.class)
class UserTest {

	@Autowired
	private UserRepository repo;
	
	
	@Test
	void testInsertUserTest() {
		
		for(int i=1; i<=100; i++) {
			UserEntity userEntity = new UserEntity();
			userEntity.setName("SON" + i);
			userEntity.setPassword("1234" + i);
			userEntity.setPhone(12345 + i);
			userEntity.setEmail("son@naver.com" + (i%10));
			userEntity.setUserId("sjw"+i);
			repo.save(userEntity);
		}
	}

}
