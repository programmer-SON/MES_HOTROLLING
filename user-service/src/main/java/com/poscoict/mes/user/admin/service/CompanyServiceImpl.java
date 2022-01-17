package com.poscoict.mes.user.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscoict.mes.user.admin.jpa.CompanyEntity;
import com.poscoict.mes.user.admin.jpa.CompanyRepository;
import com.poscoict.mes.user.admin.vo.ResponseCompany;

@Service
public class CompanyServiceImpl implements CompanyService{

    CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<ResponseCompany> getCompanies() {
        Iterable<CompanyEntity> companyList  = companyRepository.findAll();
        List<ResponseCompany> result = new ArrayList<>();

        companyList.forEach(v -> {
            result.add(new ModelMapper().map(v, ResponseCompany.class));
        });

        return result;
    }
}
