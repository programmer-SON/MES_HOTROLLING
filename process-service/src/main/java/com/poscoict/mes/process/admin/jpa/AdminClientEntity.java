package com.poscoict.mes.process.admin.jpa;

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
@Table( name = "admin_client" )
public class AdminClientEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String clientId;
	private String clientName;
	private String clientEmail;
	private String clientNumber;
	private Date clientUpdate;
}
