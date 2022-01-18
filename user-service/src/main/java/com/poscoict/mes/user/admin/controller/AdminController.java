package com.poscoict.mes.user.admin.controller;

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

import com.poscoict.mes.user.admin.jpa.AdminProductEntity;
import com.poscoict.mes.user.admin.jpa.AdminProductRepository;
import com.poscoict.mes.user.admin.jpa.CompanyEntity;
import com.poscoict.mes.user.admin.jpa.CompanyRepository;
import com.poscoict.mes.user.admin.vo.ResponseAdminProduct;
import com.poscoict.mes.user.admin.vo.ResponseCompany;

@RestController
@RequestMapping("/")
public class AdminController {
	
	AdminProductRepository adminProductRepository;
	CompanyRepository companyRepository;

	
	@Autowired
	public AdminController(AdminProductRepository adminProductRepository,
			CompanyRepository companyRepository) {
		this.adminProductRepository = adminProductRepository;
		this.companyRepository = companyRepository;
	}

	
	@GetMapping("/product_log")
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
	

    @GetMapping("/companies")
    public ResponseEntity<List<ResponseCompany>> getCompanies(){
        Iterable<CompanyEntity> companyList  = companyRepository.findAll();
        List<ResponseCompany> result = new ArrayList<>();

        companyList.forEach(v -> {
            result.add(new ModelMapper().map(v, ResponseCompany.class));
        });

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
	
}
