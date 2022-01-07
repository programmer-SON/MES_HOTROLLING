package com.poscoict.mes.process.order.jpa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table( name = "orders" )
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String order_id;
	private String product_id;
	private String company_id;
	private String user_id;
	private Date process_start;
	private Date process_end;
	private Date regdate;
	private Integer stock_plan;
	private String status;
	
}
