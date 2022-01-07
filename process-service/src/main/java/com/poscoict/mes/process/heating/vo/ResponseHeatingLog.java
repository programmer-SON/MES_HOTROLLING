package com.poscoict.mes.process.heating.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseHeatingLog {
	
	private Integer heating_furnance_id;
	private Double preheating_zone_temp;
	private Double heating_zone_temp;
	private Double soaking_zone_temp;
	private Date heating_furnance_update;
	
}
