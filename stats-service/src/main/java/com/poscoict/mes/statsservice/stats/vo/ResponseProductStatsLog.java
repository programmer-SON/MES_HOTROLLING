package com.poscoict.mes.statsservice.stats.vo;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseProductStatsLog {
	
	private String productId;
	private Double thickness;
	private Integer width;
	private Integer length;
	private String productStatus;
	private LocalTime productUpdate;
	
}
