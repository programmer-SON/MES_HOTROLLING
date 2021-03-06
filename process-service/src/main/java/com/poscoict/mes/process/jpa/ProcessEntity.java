package com.poscoict.mes.process.jpa;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table( name = "process" )
public class ProcessEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String productId;
	private Float thickness;
	private Float width;
	private Float length;
	private Integer stock;
	
}
