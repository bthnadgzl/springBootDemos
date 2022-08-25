package com.demo.orders.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orderdetail")
@Data
@NoArgsConstructor
public class OrderDetail {
	
	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(name="UUID",strategy="org.hibernate.id.UUIDGenerator")
	@JsonProperty("orderdetail_id")
	private UUID orderDetailId;
	
	@Column(name="order_id", nullable=false)
	@JsonProperty("order_id")
	private UUID orderId;
	
	@Column(name = "product", nullable=false, columnDefinition = "BINARY(16)")
	@JsonProperty("product_id")
	private UUID productId;
	
	@Column(name="quantity")
	@JsonProperty("quantity")
	private int quantity;
	
	@Column(name="price")
	@JsonProperty("price")
	private float price;
	
	

}
