package com.demo.orders.util;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.orders.entity.Customers;

@org.springframework.cloud.openfeign.FeignClient(value="feignDemo",url="http://localhost:8080/api_customers")
public interface CustomersService {

	@GetMapping("/search_by_uuid/{uuid}")
	public Customers searchByUuid(@PathVariable UUID uuid);
}
