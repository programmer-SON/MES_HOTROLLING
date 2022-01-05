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
	
	
//	entity.setOrder_id("A1234" + i);
//	entity.setProduct_id("B1234" + i);
//	entity.setProcess_start(new Date());
//	entity.setProcess_end(new Date());
//	entity.setProduct_id("C1234"+i);
//	entity.setUser_id("D1234"+i);
//	entity.setStock_plan(200);
//	if(i % 2 == 0) {
//		entity.setStatus("진행중");
//	}else {
//		entity.setStatus("완료");
//	}
}
