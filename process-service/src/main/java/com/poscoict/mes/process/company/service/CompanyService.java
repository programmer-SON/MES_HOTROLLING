package com.poscoict.mes.process.company.service;

import com.poscoict.mes.process.company.vo.ResponseCompany;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface CompanyService{
    public List<ResponseCompany> getCompanies();
}
