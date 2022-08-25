package com.demo.orders.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.orders.entity.Customers;
import com.demo.orders.entity.OrderDetail;
import com.demo.orders.entity.Orders;
import com.demo.orders.repository.OrdersDao;
import com.demo.orders.repository.OrdersDetailDao;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired OrdersDao ordersDao;
	@Autowired OrdersDetailDao ordersDetailDao;
	
	/////////
	//Orders/
	/////////
	
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
	
	@Override
	public void checkPermission(Customers customer) throws Exception {
		if(customer.isPermission() != true) {
			throw new Exception("This customer have no permission.");
		}
	}
	
	@Override
	public Orders isOrderExist(UUID customerId) throws Exception{
		if(ordersDao.existsByCustomerId(customerId)) {
		return ordersDao.findByCustomerId(customerId);
	}
		else {
			throw new Exception("Order(Cart) is not exist for given customer.");
		}
}
	@Override
	public float calculateTotalPrice(UUID orderId) {
		List<OrderDetail> orderDetails = ordersDetailDao.findAllByOrderId(orderId);
		float totalPrice = 0;
		for(OrderDetail orderDetail: orderDetails) {
			totalPrice += orderDetail.getPrice() * orderDetail.getQuantity();
		}
		return totalPrice;
	}
	
	////////////////
	//OrdersDetail//
	////////////////
	
	@Override
	public OrderDetail create(OrderDetail orderDetail) {
		return ordersDetailDao.save(orderDetail);
	}

	
}