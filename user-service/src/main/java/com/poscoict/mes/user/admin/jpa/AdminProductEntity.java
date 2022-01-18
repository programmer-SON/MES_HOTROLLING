package com.poscoict.mes.user.admin.jpa;


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
public class AdminProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String productId;
	private Double thickness;
	private Double width;
	private Double length;
	private String productStatus;
	private String productUpdate;
	
}
