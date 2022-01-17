package com.poscoict.mes.user.admin.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseAdminProduct {
	
	private String productId;
	private Double thickness;
	private Integer width;
	private Integer length;
	private String productStatus;
	private String productUpdate;
	
}
