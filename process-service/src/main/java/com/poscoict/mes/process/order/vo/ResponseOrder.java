package com.poscoict.mes.process.order.vo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.poscoict.mes.process.company.vo.ResponseCompany;
import com.poscoict.mes.process.product.vo.ResponseProduct;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonInclude
public class ResponseOrder {

	private String orderId;
	private String userId;
	private String productId;
	private String companyId;
	
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private String processStart;
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private String processEnd;
	private Integer stockPlan;
	private String status;

	List<ResponseCompany> companyList;
	List<ResponseProduct> productList;
	ResponseUser responseUser;
}
