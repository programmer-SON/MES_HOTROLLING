package com.poscoict.mes.process.product.vo;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonInclude
public class ResponseProductLog {
	
	private String product_id;
	private Integer thickness;
	private Integer width;
	private Integer length;
	private String product_status;
	private LocalTime product_update;
	
}
