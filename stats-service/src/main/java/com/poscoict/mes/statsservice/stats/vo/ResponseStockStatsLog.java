package com.poscoict.mes.statsservice.stats.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseStockStatsLog {
	
	private String productId;
	private Integer stockPlan;
	private Integer stock;
	private Integer makingStock;
	private String status;
	
}
