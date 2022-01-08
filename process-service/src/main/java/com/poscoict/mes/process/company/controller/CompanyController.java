package com.poscoict.mes.process.company.controller;

import com.poscoict.mes.process.company.jpa.CompanyEntity;
import com.poscoict.mes.process.company.jpa.CompanyRepository;
import com.poscoict.mes.process.company.vo.ResponseCompany;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("process-service")
public class CompanyController {

    CompanyRepository companyRepository;

    @Autowired
    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("companies")
    public ResponseEntity<List<ResponseCompany>> getCompanies(){
        Iterable<CompanyEntity> companyList  = companyRepository.findAll();
        List<ResponseCompany> result = new ArrayList<>();

        companyList.forEach(v -> {
            result.add(new ModelMapper().map(v, ResponseCompany.class));
        });

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
