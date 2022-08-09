package com.demo.products.repository;

import java.util.List;
import java.util.UUID;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.demo.products.entity.Products;

@Repository
public interface ProductsDao extends PagingAndSortingRepository<Products,UUID>{
	List<Products> findAllByCategory(String category);
}
