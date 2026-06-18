package com.projects.spring_data_jpa.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(
		name="products", 
		schema="springjpadb",
		uniqueConstraints= {
				@UniqueConstraint(
						name="sku_unique",
						columnNames="sku"
						)
		}
	)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
	@Id
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE,
			generator="product-sequence_generator"
	)
	@SequenceGenerator(
			name="product-sequence_generator",
			sequenceName="product-sequence-name",
			allocationSize=1
	)
	private Long id;
	@Column(name="stock_keeping_unit", nullable=false)
	private String sku;//(short for stock keeping unit)
	@Column(nullable=false)
	private String name;
	private String description;
	private BigDecimal price;
	private boolean active;
	private String imageUrl;
	@CreationTimestamp
	private LocalDateTime dateCreated;
	@UpdateTimestamp
	private LocalDateTime lastUpdated;
	
}
