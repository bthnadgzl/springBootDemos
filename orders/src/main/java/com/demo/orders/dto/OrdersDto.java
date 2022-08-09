package com.demo.orders.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OrdersDto {

	@JsonProperty("customer_id")
	private UUID customerId;
	@JsonProperty("product_id")
	private UUID productId;
	@JsonProperty("quantity")
	private int quantity;
}
