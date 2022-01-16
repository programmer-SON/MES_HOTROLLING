package com.poscoict.mes.process.order.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class RequestOrder {
	
	private String userId;
	private String productId;
	private String companyId;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private String processStart;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private String processEnd;
	private Integer stockPlan;
	
}
