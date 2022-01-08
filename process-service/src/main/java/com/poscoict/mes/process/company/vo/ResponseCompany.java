package com.poscoict.mes.process.company.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCompany {
    private String companyId;
    private String name;
}
