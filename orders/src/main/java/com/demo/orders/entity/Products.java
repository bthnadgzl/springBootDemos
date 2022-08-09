package com.demo.orders.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="products")
@Data
@NoArgsConstructor
public class Products {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name= "UUID" , strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="product", updatable=false, nullable=false, columnDefinition = "BINARY(16)")
	@JsonProperty("product_id")
	private UUID productId;
	
	@Column(updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate = new Date();
	
	@Column(name="name")
	@JsonProperty("name")
	private String name;
	
	@Column(name="color")
	@JsonProperty("color")
	private String color;
	
	@Column(name="category")
	@JsonProperty("category")
	private String category;
	
	@Column(name="price")
	@JsonProperty("price")
	private float price;

	
	public Products(String name,String color,String category,float price) {
		this.name=name;
		this.color=color;
		this.category=category;
		this.price=price;
	}
	
	
	
	

}
