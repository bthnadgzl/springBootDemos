package com.demo.products.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Products> getAll() {
		return (List<Products>) productsDao.findAll();
	}

	@Override
	public List<Products> getByCategory(String category) {
		return (List<Products>) productsDao.findAllByCategory(category);
	}
	

}
