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
@Table(name="orders")
@Data
@NoArgsConstructor
public class Orders {

	
	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(name="UUID",strategy="org.hibernate.id.UUIDGenerator")
	@Column(name="order_id", updatable=false, nullable=false, columnDefinition = "BINARY(16)")
	@JsonProperty("order_id")
	private UUID orderId;
	
	@Column(updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate = new Date();
	
	@Column(name = "customer", nullable=false, columnDefinition = "BINARY(16)")
	@JsonProperty("customer_id")
	private UUID customerId;
	
	@Column(name="customer_name")
	@JsonProperty("customer_name")
	private String customerName;
	
	@Column(name="customer_surname")
	@JsonProperty("customer_surname")
	private String customerSurname;
	
	@Column(name="adress") //name gibi özellikleri getir
	@JsonProperty("adress")
	private String adress;
	
	@Column(name="total_price")
	@JsonProperty("total_price")
	private float totalPrice;
	
	

	public Orders(UUID customerId) {
		this.customerId = customerId;
	}
	
	
}
