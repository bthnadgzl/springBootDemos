package com.demo.orders.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OrdersShowDto {
	
	@JsonProperty("order_id")
	private UUID orderId;
	
	@JsonProperty("customer_id")
	private UUID customerId;

	@JsonProperty("customer_name")
	private String customerName;

	@JsonProperty("customer_surname")
	private String customerSurname;

	@JsonProperty("adress")
	private String adress;
	
	@JsonProperty("total_price")
	private float totalPrice;
	
}
