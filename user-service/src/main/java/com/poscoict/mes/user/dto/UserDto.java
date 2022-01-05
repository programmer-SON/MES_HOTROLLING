package com.poscoict.mes.user.dto;

import lombok.Data;

@Data
public class UserDto {

	private Long id;
	
	private String person_id;
	private String password;
	private String name;
	private Integer phone;
	private String email;	
	
}
