package com.demo.products.repository;

import java.util.List;
import java.util.UUID;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.products.entity.Products;

@Repository
public interface ProductsDao extends CrudRepository<Products,UUID>{
	List<Products> findAllByCategory(String category);
}
