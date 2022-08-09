package com.demo.products.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.products.entity.Products;
import com.demo.products.repository.ProductsDao;

@Service
public class ProductsServiceImpl implements ProductsService{
	
	@Autowired private ProductsDao productsDao;
	
	
	@Override
	public Products create(Products product) {
		return productsDao.save(product);
		
	}

	@Override
	public Products update(Products product) {
		return productsDao.save(product);
	}

	@Override
	public void delete(UUID uuid) {
		productsDao.deleteById(uuid);
		
	}

	@Override
	public Products search(UUID uuid) {
		return productsDao.findById(uuid).get();
	}

	@Override
	public Page<Products> getAll(Optional<Integer> page, Optional<String> sortBy) {
		return  productsDao.findAll(PageRequest.of(page.orElse(0),5,Sort.Direction.ASC,sortBy.orElse("name")));
	}

	@Override
	public List<Products> getByCategory(String category) {
		return (List<Products>) productsDao.findAllByCategory(category);
	}
	

}
