package com.poscoict.mes.process.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poscoict.mes.process.admin.jpa.AdminMemberEntity;
import com.poscoict.mes.process.admin.jpa.AdminMemberRepository;
import com.poscoict.mes.process.admin.jpa.AdminNewMemberEntity;
import com.poscoict.mes.process.admin.jpa.AdminNewMemberRepository;
import com.poscoict.mes.process.admin.vo.ResponseAdminMember;
import com.poscoict.mes.process.admin.vo.ResponseAdminNewMember;

@RestController
@RequestMapping("/process-service")
public class AdminController {
	
	AdminMemberRepository adminMemberRepository;
	AdminNewMemberRepository adminNewMemberRepository;
	
	@Autowired
	public AdminController(AdminMemberRepository adminMemberRepository,
			AdminNewMemberRepository adminNewMemberRepository) {
		this.adminMemberRepository = adminMemberRepository;
		this.adminNewMemberRepository = adminNewMemberRepository;
	}

	@GetMapping("/admin_member")
	public ResponseEntity<List<ResponseAdminMember>> getAdminMember(){		
		Iterable<AdminMemberEntity> adminMemberList = adminMemberRepository.findAll();
		List<ResponseAdminMember> result = new ArrayList<>();
		
		adminMemberList.forEach(v -> {
			result.add(new ModelMapper().map(v, ResponseAdminMember.class));
		});
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@GetMapping("/admin_new_member")
	public ResponseEntity<List<ResponseAdminNewMember>> getAdminNewMember(){		
		Iterable<AdminNewMemberEntity> adminNewMemberList = adminNewMemberRepository.findAll();
		List<ResponseAdminNewMember> result = new ArrayList<>();
		
		adminNewMemberList.forEach(v -> {
			result.add(new ModelMapper().map(v, ResponseAdminNewMember.class));
		});
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
}
