package com.poscoict.mes.process.order.jpa;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table( name = "orders" )
@SequenceGenerator(
		name="ORDER_SEQ_GENERATOR",
		sequenceName = "ORDER_SEQ",
		initialValue = 1,
		allocationSize = 1
)
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ_GENERATOR")
	private String orderId;

	private String productId;
	private String companyId;
	private String userId;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date processStart;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date processEnd;

	private Date regdate;
	private Integer stockPlan;
	@Column(columnDefinition = "varchar(255) default 'processing'")
	private String status;
	
}
