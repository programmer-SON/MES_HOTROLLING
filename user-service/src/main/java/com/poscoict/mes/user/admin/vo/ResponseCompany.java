package com.poscoict.mes.user.admin.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCompany {
	private String companyId;
    private String name;
    private int phone;
    private String email;
}
