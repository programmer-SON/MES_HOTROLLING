package com.poscoict.mes.process.heating.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseHeatingLog {
	
	private String heatingFurnanceId;
	private Integer preheatingZoneTemp;
	private Integer heatingZoneTemp;
	private Integer soakingZoneTemp;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private String heatingFurnanceUpdate;
	
}
