package com.poscoict.mes.apigateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

	private String name;
	private String email;
	private String pwd;
}
