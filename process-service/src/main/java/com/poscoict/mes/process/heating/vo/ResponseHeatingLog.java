package com.poscoict.mes.process.heating.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseHeatingLog {
	
	private Integer heatingFurnanceId;
	private Double preheatingZoneTemp;
	private Double heatingZoneTemp;
	private Double soakingZoneTemp;
	private Date heatingFurnanceUpdate;
	
}
