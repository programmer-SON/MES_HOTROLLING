package com.poscoict.mes.user.admin.jpa;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
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
