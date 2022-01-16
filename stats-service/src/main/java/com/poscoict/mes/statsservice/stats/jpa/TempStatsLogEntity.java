package com.poscoict.mes.statsservice.stats.jpa;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table( name = "heating_furnance_temperature_log" )
public class TempStatsLogEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String heatingFurnanceId;
	private Integer preheatingZoneTemp;
	private Integer heatingZoneTemp;
	private Integer soakingZoneTemp;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private String heatingFurnanceUpdate;
	
}
