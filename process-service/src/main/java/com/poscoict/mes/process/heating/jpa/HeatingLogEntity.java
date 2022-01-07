package com.poscoict.mes.process.heating.jpa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table( name = "heating_furnance_temperature_log" )
public class HeatingLogEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer heating_furnance_id;
	private Double preheating_zone_temp;
	private Double heating_zone_temp;
	private Double soaking_zone_temp;
	private Date heating_furnance_update;
}
