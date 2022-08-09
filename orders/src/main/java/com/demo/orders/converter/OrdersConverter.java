package com.demo.orders.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.demo.orders.dto.OrdersDto;
import com.demo.orders.entity.Orders;

@Component
public class OrdersConverter {

	public OrdersDto entityToDto(Orders order) {
		OrdersDto ordersDto = new OrdersDto();
		ordersDto.setCustomerId(order.getCustomerId());
		ordersDto.setProductId(order.getProductId());
		ordersDto.setQuantity(order.getQuantity());
		return ordersDto;
	}
	public List<OrdersDto> entityToDto(List<Orders> order) {
		return order.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	public Orders dtoToEntity(OrdersDto orderDto) {
		Orders order = new Orders();
		order.setCustomerId(orderDto.getCustomerId());
		order.setProductId(orderDto.getProductId());
		order.setQuantity(orderDto.getQuantity());
		return order;
	}
	
	public List<Orders> dtoToEntity(List<OrdersDto> orderDto) {
		return orderDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
	
}
