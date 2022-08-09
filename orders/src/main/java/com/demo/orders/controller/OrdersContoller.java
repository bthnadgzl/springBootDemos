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
import com.demo.orders.dto.OrdersDto;
import com.demo.orders.entity.Customers;
import com.demo.orders.entity.Orders;
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
	
	@PostMapping
	public ResponseEntity<OrdersDto> create(@RequestBody OrdersDto orderDto) throws Exception {
		Orders order = ordersConverter.dtoToEntity(orderDto);
		Customers customer = customersService.searchByUuid((UUID) orderDto.getCustomerId());
		order.setAdress(customer.getAdress());
		order.setProduct(productsService.search((UUID) orderDto.getProductId()));
		if(customer.isPermission()) {
			ordersService.create(order);
			return ResponseEntity.ok(orderDto);
		}
		else {
			throw new Exception("This customer have no permission.");
		}
	}
	
	@PutMapping
	public ResponseEntity<Orders> update(@RequestBody Orders order){	
		Customers customer = customersService.searchByUuid(order.getCustomerId());
		order.setAdress(customer.getAdress());
		order.setProduct(productsService.search(order.getProductId()));
		if(customer.isPermission()) {
			ordersService.update(order);
			return ResponseEntity.ok(order);
		}
		else {
			System.out.println("This user have no permission.");
			return null;
		}
	}
	
	@DeleteMapping("/{uuid}")
	public void delete(@PathVariable UUID uuid) {
		ordersService.delete(uuid);
	}
	@GetMapping("/{uuid}") //search specific order.
	public ResponseEntity<OrdersDto> search(UUID uuid){
		Orders order = ordersService.search(uuid);
		return ResponseEntity.ok(ordersConverter.entityToDto(order));
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
