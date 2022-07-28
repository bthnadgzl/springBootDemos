package com.demo.products.service;

import java.util.List;
import java.util.UUID;

import com.demo.products.entity.Products;

public interface ProductsService {

	
	public Products create(Products product);
	public Products update(Products product);
	public void delete(UUID uuid);
	public Products search(UUID uuid);
	public List<Products> getAll();
	public List<Products> getByCategory(String category);
	
}
