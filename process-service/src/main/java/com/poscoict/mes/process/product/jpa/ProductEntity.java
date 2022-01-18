package com.poscoict.mes.process.product.jpa;

import javax.persistence.*;
import javax.ws.rs.DefaultValue;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;

@Data
@Entity
@ToString
@Table( name = "product" )
public class ProductEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String productId;
	private Double thickness;
	private Double width;
	private Double length;

}
