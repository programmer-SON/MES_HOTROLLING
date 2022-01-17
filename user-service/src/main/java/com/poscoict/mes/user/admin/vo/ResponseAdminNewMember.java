package com.poscoict.mes.user.admin.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseAdminNewMember {
	
	private String newMemberId;
	private String newMemberEmail;
	private String newMemberPw;
	private Date newMemberUpdate;
	
}
