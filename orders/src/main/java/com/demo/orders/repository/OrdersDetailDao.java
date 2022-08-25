package com.demo.orders.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.demo.orders.entity.OrderDetail;

@Repository
public interface OrdersDetailDao extends PagingAndSortingRepository<OrderDetail, UUID>{
	List<OrderDetail> findAllByOrderId(UUID orderId);
}
