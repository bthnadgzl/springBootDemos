package com.demo.products.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.demo.products.entity.Products;

public interface ProductsService {

	
	public Products create(Products product);
	public Products update(Products product);
	public void delete(UUID uuid);
	public Products search(UUID uuid);
	public Page<Products> getAll(Optional<Integer> page, Optional<String> sortBy);
	public List<Products> getByCategory(String category);
	
}
