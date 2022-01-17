package com.poscoict.mes.user.jpa;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.poscoict.mes.user.vo.RequestLogin;

@SpringBootTest
//@RunWith(SpringRunner.class)
class UserTest {

	private UserRepository repo;
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	public UserTest(UserRepository repo, BCryptPasswordEncoder passwordEncoder) {
		this.repo = repo;
		this.passwordEncoder = passwordEncoder;
	}

	//	@Test
//	void testInsertUserTest() {
//
//		for(int i=1; i<=100; i++) {
//			UserEntity userEntity = new UserEntity();
//			userEntity.setName("SON" + i);
//			userEntity.setPassword("1234" + i);
//			userEntity.setPhone(12345 + i);
//			userEntity.setEmail("son@naver.com" + (i%10));
//			userEntity.setUserId("sjw"+i);
//			repo.save(userEntity);
//		}
//	}

	@Test
	void UserLoginTest(){
		RequestLogin user = new RequestLogin();
		user.setUserId("admin@poscoict.com");
		user.setPassword("1234");

		String userId = user.getUserId();
		String password =user.getPassword();

		UserEntity userEntity = repo.findByUserId(userId);

		if(passwordEncoder.matches(password, userEntity.getEncryptedPwd())){
			Assertions.assertThat(password).isEqualTo(userEntity.getEncryptedPwd());
			//System.out.println("true");
		}

//		if(userEntity == null){
//			throw new UsernameNotFoundException(userId);
//		}



		//UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);

	}

}
