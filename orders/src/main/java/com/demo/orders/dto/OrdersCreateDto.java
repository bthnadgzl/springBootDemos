package com.demo.orders.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OrdersCreateDto {

	@JsonProperty("customer_id")
	private UUID customerId;

}
