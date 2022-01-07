package com.poscoict.mes.process.order.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonInclude
public class ResponseOrder {
	
	private String userId;
	private String orderId;
	private String productId;
	private String companyId;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date processStart;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date processEnd;
	private Integer stockPlan;
	private String status;
	
}
