package com.demo.orders.util;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.orders.entity.Products;
@FeignClient(value="ProductsService",url="http://localhost:8082/apiProducts")
public interface ProductsService {
	@GetMapping("/search/{uuid}")
	public Products search(@PathVariable UUID uuid);
	
}
