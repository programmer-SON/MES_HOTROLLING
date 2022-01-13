package com.poscoict.mes.statsservice.stats.jpa;


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
@Table( name = "stock_stats_log" )
public class StockStatsLogEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String productId;
	private Integer stockPlan;
	private Integer stock;
	private Integer makingStock;
	private String status;
	
}
