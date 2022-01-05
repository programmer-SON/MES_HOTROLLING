package com.poscoict.mes.apigateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poscoict.mes.apigateway.dto.UserDto;

//@CrossOrigin(origins = "http://localhost:8085")
@RestController
@RequestMapping("restapi")
public class Controller {
	
	
	@GetMapping("/users")
	public ResponseEntity<UserDto> getUsers(){
		
		UserDto userDto = new UserDto("SON","JUN","WOO");
		
		return ResponseEntity.status(HttpStatus.OK).body(userDto);		
	}
}
