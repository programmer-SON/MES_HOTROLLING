package com.poscoict.mes.user.admin.jpa;

import java.util.Date;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminNewMemberTest {

	@Autowired
	AdminNewMemberRepository repo;
	
	@Test
	@DisplayName("insertAdminNewMember")
	void insertAdminNewMember() {
		IntStream.range(1, 10).forEach(i -> {
			AdminNewMemberEntity entity = new AdminNewMemberEntity();
			entity.setNewMemberId("NewGuest" + i);
			entity.setNewMemberEmail("NewTest"+i+"@gmail.com");
			entity.setNewMemberPw("NewTest" + i);
			entity.setNewMemberUpdate(new Date());
			
			repo.save(entity);
		});	
	}
	
	@Test
	void getHAdminNewMember() {}

}
