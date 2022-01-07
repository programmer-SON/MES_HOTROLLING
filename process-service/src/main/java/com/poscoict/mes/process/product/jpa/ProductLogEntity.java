package com.poscoict.mes.process.product.jpa;


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
@Table( name = "product_log" )
public class ProductLogEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String product_id;
	private Integer thickness;
	private Integer width;
	private Integer length;
	private String product_status;
	private LocalTime product_update;
	
}
