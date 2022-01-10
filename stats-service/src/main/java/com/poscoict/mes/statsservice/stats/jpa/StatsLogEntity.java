package com.poscoict.mes.statsservice.stats.jpa;


import java.time.LocalTime;

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
@Table( name = "stats_log" )
public class StatsLogEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String statsId;
	private Integer thickness;
	private Integer width;
	private Integer length;
	private String statsStatus;
	private LocalTime statsUpdate;
	
}
