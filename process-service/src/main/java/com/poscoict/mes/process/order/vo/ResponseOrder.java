package com.poscoict.mes.process.order.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonInclude
public class ResponseOrder {
	
	private String user_id;
	private String order_id;
	private String product_id;
	private String company_id;
	private Date process_start;
	private Date process_end;
	private Integer stock_plan;
	private String status;
	
}
