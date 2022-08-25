package com.demo.orders.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OrderDetailDto {

	
	private UUID orderId;
	
	private UUID productId;
	
	private int quantity;
	
	private float price;
	
	
}
