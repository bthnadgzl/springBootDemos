package com.demo.products.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.demo.products.converter.ProductsConverter;
import com.demo.products.dto.ProductsDto;
import com.demo.products.entity.Products;
import com.demo.products.service.ProductsService;

@RestController
@RequestMapping("/api_products")
public class ProductsController {
	
	@Autowired ProductsService productsService;
	@Autowired ProductsConverter productsConverter;
	
	
	
	
	@PostMapping
	public ResponseEntity<ProductsDto> create(@RequestBody ProductsDto productDto) {
		Products product = productsConverter.dtoToEntity(productDto);
		productsService.create(product);
		return ResponseEntity.ok(productDto);
	}

	@PutMapping
	public ResponseEntity<Products> update(@RequestBody Products product) { //UUID needed.
		return ResponseEntity.ok(productsService.create(product));
	}
	
	@DeleteMapping("/{uuid}")
	public void delete(@PathVariable UUID uuid) {
		productsService.delete(uuid);
	}
	
	@GetMapping("/{uuid}")
	public ResponseEntity<Products> search(@PathVariable UUID uuid) {
		Products product = productsService.search(uuid);
		return ResponseEntity.ok(product);
	}
	
	@GetMapping
	public ResponseEntity<Page<Products>> getAll(Optional<Integer> page, Optional<String> sortBy){
		Page<Products> products = productsService.getAll(page,sortBy);
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/search_by_category/{category}")
	public ResponseEntity<List<ProductsDto>> getByCategory(@PathVariable String category){
		List<Products> products = productsService.getByCategory(category);
		return ResponseEntity.ok(productsConverter.entityToDto(products));
	}
	
}


