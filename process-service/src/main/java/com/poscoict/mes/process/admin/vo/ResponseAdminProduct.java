package com.poscoict.mes.process.admin.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseAdminProduct {
	
	private String productId;
	private Integer productLen;
	private Integer productWidth;
	private Integer productThick;
	private Date productUpdate;
	
}
