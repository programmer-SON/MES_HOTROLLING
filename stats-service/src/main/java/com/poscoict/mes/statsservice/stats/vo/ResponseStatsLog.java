package com.poscoict.mes.statsservice.stats.vo;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseStatsLog {
	
	private String statsId;
	private Integer thickness;
	private Integer width;
	private Integer length;
	private String statsStatus;
	private LocalTime statsUpdate;
	
}
