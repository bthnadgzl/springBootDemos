package com.demo.orders.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.demo.orders.entity.Customers;
import com.demo.orders.entity.OrderDetail;
import com.demo.orders.entity.Orders;

public interface OrdersService {

	//Orders
	public Orders create(Orders order);
	public Orders update(Orders order);
	public void delete(UUID orderId);
	public Orders search(UUID orderId);
	public Page<Orders> getAll(Optional<Integer> Page,  Optional<String> SortBy);
	public List<Orders> searchByCustomerUuid(UUID customerId);
	public void checkPermission(Customers customer) throws Exception;
	public Orders isOrderExist(UUID customerId) throws Exception;
	public float calculateTotalPrice(UUID orderId);
	
	//OrderDetails
	public OrderDetail create(OrderDetail orderDetail);
	
}
