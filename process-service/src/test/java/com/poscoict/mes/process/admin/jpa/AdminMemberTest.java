package com.poscoict.mes.process.admin.jpa;

import java.util.Date;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminMemberTest {

	@Autowired
	AdminMemberRepository repo;
	
	@Test
	@DisplayName("insertAdminMember")
	void insertAdminMember() {
		IntStream.range(1, 10).forEach(i -> {
			AdminMemberEntity entity = new AdminMemberEntity();
			entity.setMemberId("Guest" + i);
			entity.setMemberEmail("test"+i+"@gmail.com");
			entity.setMemberPw("test" + i);
			entity.setMemberUpdate(new Date());
			
			repo.save(entity);
		});	
	}
	
	@Test
	void getHAdminMember() {}

}
