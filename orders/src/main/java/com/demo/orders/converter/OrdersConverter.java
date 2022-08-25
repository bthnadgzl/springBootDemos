package com.demo.orders.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.orders.dto.OrderDetailCreateDto;
import com.demo.orders.dto.OrdersCreateDto;
import com.demo.orders.dto.OrdersShowDto;
import com.demo.orders.entity.OrderDetail;
import com.demo.orders.entity.Orders;

@Component
public class OrdersConverter {

	@Autowired ModelMapper mapper;
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	//ORDER_SHOW_CONVERTER
	
	public OrdersShowDto entityToOrderShowDto(Orders order) {
		OrdersShowDto ordersDto = mapper.map(order , OrdersShowDto.class);	
		return ordersDto;
	}
	public List<OrdersShowDto> entityToOrderShowDto(List<Orders> order) {
		return order.stream().map(x -> entityToOrderShowDto(x)).collect(Collectors.toList());
	}
	
	public Orders dtoToEntity(OrdersShowDto orderDto) {
		Orders order = mapper.map(orderDto, Orders.class);
		return order;
	}
	
	public List<Orders> orderShowDtoToEntity(List<OrdersShowDto> orderDto) {
		return orderDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	//ORDER_CREATE_CONVERTER
	
	public OrdersCreateDto entityToOrderCreateDto(Orders order) {
		OrdersCreateDto ordersDto = mapper.map(order , OrdersCreateDto.class);	
		return ordersDto;
	}
	public List<OrdersCreateDto> entityToOrderCreateDto(List<Orders> order) {
		return order.stream().map(x -> entityToOrderCreateDto(x)).collect(Collectors.toList());
	}
	
	public Orders orderCreateDtoToEntity(OrdersCreateDto orderDto) {
		Orders order = mapper.map(orderDto, Orders.class);
		return order;
	}
	
	public List<Orders> orderCreateDtoToEntity(List<OrdersCreateDto> orderDto) {
		return orderDto.stream().map(x -> orderCreateDtoToEntity(x)).collect(Collectors.toList());
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	//ORDER_DETAİL_CREATE_CONVERTER
	
	public OrderDetailCreateDto entityToOrderDetailCreateDto(OrderDetail orderDetail) {
		OrderDetailCreateDto orderDetailCreateDto = mapper.map(orderDetail, OrderDetailCreateDto.class);
		return orderDetailCreateDto;
	}
	
	public List<OrderDetailCreateDto> entityToOrderDetailCreateDto(List<OrderDetail> order) {
		return order.stream().map(x -> entityToOrderDetailCreateDto(x)).collect(Collectors.toList());
	}
	
	public OrderDetail orderDetailCreateDtoToEntity(OrderDetailCreateDto orderDetailCreateDto) {
		OrderDetail orderDetail = mapper.map(orderDetailCreateDto, OrderDetail.class);
		return orderDetail;
	}
	
	public List<OrderDetail> orderDetailCreateDtoToEntity(List<OrderDetailCreateDto> orderDetailCreateDto) {
		return orderDetailCreateDto.stream().map(x -> orderDetailCreateDtoToEntity(x)).collect(Collectors.toList());
	}
	
	
}
