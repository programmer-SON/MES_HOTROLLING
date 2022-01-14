package com.poscoict.mes.process.company.service;

import com.poscoict.mes.process.company.jpa.CompanyEntity;
import com.poscoict.mes.process.company.jpa.CompanyRepository;
import com.poscoict.mes.process.company.vo.ResponseCompany;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
