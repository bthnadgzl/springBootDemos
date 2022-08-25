package com.demo.orders.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orders.converter.OrdersConverter;
import com.demo.orders.dto.OrderDetailCreateDto;
import com.demo.orders.dto.OrdersCreateDto;
import com.demo.orders.dto.OrdersShowDto;
import com.demo.orders.entity.Customers;
import com.demo.orders.entity.OrderDetail;
import com.demo.orders.entity.Orders;
import com.demo.orders.entity.Products;
import com.demo.orders.service.OrdersService;
import com.demo.orders.util.CustomersService;
import com.demo.orders.util.ProductsService;

@RestController
@RequestMapping("/api_orders")
public class OrdersContoller {
	
	@Autowired OrdersService ordersService;
	@Autowired OrdersConverter ordersConverter;
	
	@Autowired CustomersService customersService;
	@Autowired ProductsService productsService;
	
	//Only creates order so there is no product in it first.
	//create works like shopping cart
	@PostMapping
	public ResponseEntity<OrdersShowDto> create(@RequestBody OrdersCreateDto orderCreateDto) throws Exception {
		
		Customers customer = customersService.searchByUuid((UUID) orderCreateDto.getCustomerId());
		
		ordersService.checkPermission(customer); // If permission is false, throws an exception.
		
		Orders order = ordersConverter.orderCreateDtoToEntity(orderCreateDto); //Order Create Dto only contains customer id.
		order.setAdress(customer.getAdress());
		order.setCustomerName(customer.getName());
		order.setCustomerSurname(customer.getSurname());
		ordersService.create(order);
		
		return ResponseEntity.ok(ordersConverter.entityToOrderShowDto(order)); //Order Show Dto contains detailed information except create and update dates.
	}
	
	
	@PostMapping("/add_product_to_cart/{customerId}")
	public ResponseEntity<OrderDetail> addProductToCart(@PathVariable UUID customerId,
														@RequestBody OrderDetailCreateDto orderDetailCreateDto)
																throws Exception{
		
		
		Orders order = ordersService.isOrderExist(customerId); //Checks is Order(cart) exist.
		
		Products product = productsService.search(orderDetailCreateDto.getProductId()); //Creates product object from product id. We get price from here.
		OrderDetail orderDetail = ordersConverter.orderDetailCreateDtoToEntity(orderDetailCreateDto); //Creates orderDetail object. We will fill informations.
		
		orderDetail.setOrderId(order.getOrderId());
		orderDetail.setPrice(product.getPrice());
		ordersService.create(orderDetail);
		return ResponseEntity.ok(orderDetail);
	}
	
	
	@PutMapping
	public ResponseEntity<OrdersShowDto> update(@PathVariable UUID orderId) throws Exception{	
		
		Orders order = ordersService.isOrderExist(orderId); //Checks order
		Customers customer = customersService.searchByUuid(order.getCustomerId());
		ordersService.checkPermission(customer);
		
		order.setCustomerId(customer.getCustomerId());
		order.setCustomerName(customer.getName());
		order.setCustomerSurname(customer.getSurname());
		order.setAdress(customer.getAdress());
		order.setTotalPrice(ordersService.calculateTotalPrice(orderId));
		ordersService.update(order);
		return ResponseEntity.ok(ordersConverter.entityToOrderShowDto(order));
	}
	
	@DeleteMapping("/{uuid}")
	public void delete(@PathVariable UUID orderId) {
		ordersService.delete(orderId);
	}
	
	@GetMapping("/{uuid}") //search specific order.
	public ResponseEntity<OrdersShowDto> search(UUID orderId){
		Orders order = ordersService.search(orderId);
		return ResponseEntity.ok(ordersConverter.entityToOrderShowDto(order));
	}
	
	@GetMapping
	public ResponseEntity<Page<Orders>> getAll(@RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy){
		
		Page<Orders> orders = ordersService.getAll(page, sortBy);
		return ResponseEntity.ok(orders);
	}
	
	@GetMapping("/search_by_customer_id/{customerUuid}")
	public ResponseEntity<List<Orders>> searchByCustomerId(@PathVariable UUID customerUuid){
		List<Orders> orders = ordersService.searchByCustomerUuid(customerUuid);
		return ResponseEntity.ok(orders);
	}


}
