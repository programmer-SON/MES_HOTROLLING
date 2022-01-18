package com.poscoict.mes.user.admin.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompanyRepository  extends CrudRepository<CompanyEntity, Long> {

    Optional<CompanyEntity> findByCompanyId(String companyId);
}
