package com.poscoict.mes.user.dto;

import lombok.Data;

@Data
public class UserDto {

	private String userId;
	private String password;
	private String name;
	private Integer phone;
	private String email;

	private String encryptedPwd;
	
}
