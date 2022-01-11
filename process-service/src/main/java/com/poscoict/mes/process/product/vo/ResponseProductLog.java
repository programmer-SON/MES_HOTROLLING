package com.poscoict.mes.process.product.vo;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseProductLog {
	
	private String productId;
	private Integer thickness;
	private Integer width;
	private Integer length;
	private String productStatus;
	private LocalTime productUpdate;
	
}
