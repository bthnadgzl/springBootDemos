package com.demo.orders.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.orders.entity.Orders;
import com.demo.orders.repository.OrdersDao;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired OrdersDao ordersDao;
	
	
	
	@Override
	public Orders create(Orders order) {
		return ordersDao.save(order);
	}

	@Override
	public Orders update(Orders order) {
		return ordersDao.save(order);
	}

	@Override
	public void delete(UUID orderId) {
		ordersDao.deleteById(orderId);
		
	}

	@Override
	public Orders search(UUID orderId) {
		
		return ordersDao.findById(orderId).get();
	}

	@Override
	public Page<Orders> getAll(Optional<Integer> page,  Optional<String> sortBy) { //Pageable and sortable
		return ordersDao.findAll(PageRequest.of(page.orElse(0),5,Sort.Direction.ASC, sortBy.orElse("orderId")));
	}
	
	
	public List<Orders> searchByCustomerUuid(UUID customerId){
		return (List<Orders>) ordersDao.findAllByCustomerId(customerId);
	}
	

}
