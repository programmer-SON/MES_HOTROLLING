package com.poscoict.mes.process.order.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
public class RequestOrder {
	
//	private String userId;
//	private String orderId;
//	private String productId;
	private String companyId;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date processStart;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date processEnd;
//	private Integer stockPlan;
//	private String status;

//    @NotNull(message = "Name cannot be null")
//    @Size(min = 2, message = "Name not be less than two characters")
//    private String name;
//
//    @NotNull(message = "Password cannot be null")
//    @Size(min = 8, message = "Password must be equal or greater than 8 characters")
//    private String pwd;
    
	
}
