package com.poscoict.mes.user.admin.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseAdminMember {
	
	private String memberId;
	private String memberEmail;
	private String memberPw;
	private Date memberUpdate;
	
}
