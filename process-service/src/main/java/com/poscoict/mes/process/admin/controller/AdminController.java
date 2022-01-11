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

import com.poscoict.mes.process.admin.jpa.AdminClientEntity;
import com.poscoict.mes.process.admin.jpa.AdminClientRepository;
import com.poscoict.mes.process.admin.jpa.AdminMemberEntity;
import com.poscoict.mes.process.admin.jpa.AdminMemberRepository;
import com.poscoict.mes.process.admin.jpa.AdminNewMemberEntity;
import com.poscoict.mes.process.admin.jpa.AdminNewMemberRepository;
import com.poscoict.mes.process.admin.jpa.AdminProductEntity;
import com.poscoict.mes.process.admin.jpa.AdminProductRepository;
import com.poscoict.mes.process.admin.vo.ResponseAdminClient;
import com.poscoict.mes.process.admin.vo.ResponseAdminMember;
import com.poscoict.mes.process.admin.vo.ResponseAdminNewMember;
import com.poscoict.mes.process.admin.vo.ResponseAdminProduct;

@RestController
@RequestMapping("/process-service")
public class AdminController {
	
	AdminMemberRepository adminMemberRepository;
	AdminNewMemberRepository adminNewMemberRepository;
	AdminClientRepository adminClientRepository;
	AdminProductRepository adminProductRepository;
	
	@Autowired
	public AdminController(AdminMemberRepository adminMemberRepository,
			AdminNewMemberRepository adminNewMemberRepository,
			AdminClientRepository adminClientRepository,
			AdminProductRepository adminProductRepository) {
		this.adminMemberRepository = adminMemberRepository;
		this.adminNewMemberRepository = adminNewMemberRepository;
		this.adminClientRepository = adminClientRepository;
		this.adminProductRepository = adminProductRepository;
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
	
	@GetMapping("/admin_product")
	public ResponseEntity<List<ResponseAdminProduct>> getAdminProduct(){		
		Iterable<AdminProductEntity> adminProductList = adminProductRepository.findAll();
		List<ResponseAdminProduct> result = new ArrayList<>();
		
		adminProductList.forEach(v -> {
			result.add(new ModelMapper().map(v, ResponseAdminProduct.class));
		});
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@GetMapping("/admin_client")
	public ResponseEntity<List<ResponseAdminClient>> getAdminClient(){		
		Iterable<AdminClientEntity> adminClientList = adminClientRepository.findAll();
		List<ResponseAdminClient> result = new ArrayList<>();
		
		adminClientList.forEach(v -> {
			result.add(new ModelMapper().map(v, ResponseAdminClient.class));
		});
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
}
