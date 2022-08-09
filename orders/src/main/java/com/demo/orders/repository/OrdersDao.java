package com.demo.orders.repository;

import java.util.List;
import java.util.UUID;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.demo.orders.entity.Orders;

@Repository
public interface OrdersDao extends PagingAndSortingRepository<Orders, UUID>{
	List<Orders> findAllByCustomerId(UUID customerId);
}
