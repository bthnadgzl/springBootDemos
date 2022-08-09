package com.demo.orders.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.demo.orders.entity.Orders;

public interface OrdersService {

	public Orders create(Orders order);
	public Orders update(Orders order);
	public void delete(UUID orderId);
	public Orders search(UUID orderId);
	public Page<Orders> getAll(Optional<Integer> Page,  Optional<String> SortBy);
	public List<Orders> searchByCustomerUuid(UUID customerId);
	
	
	
}
