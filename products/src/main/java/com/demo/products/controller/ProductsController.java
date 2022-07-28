package com.demo.products.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.products.converter.ProductsConverter;
import com.demo.products.dto.ProductsDto;
import com.demo.products.entity.Products;
import com.demo.products.service.ProductsService;

@RestController
@RequestMapping("/apiProducts")
public class ProductsController {
	
	@Autowired ProductsService productsService;
	@Autowired ProductsConverter productsConverter;
	
	
	
	
	@PostMapping("/create")
	public ResponseEntity<Products> create(@RequestBody ProductsDto productDto) {
		Products product = productsConverter.dtoToEntity(productDto);
		return ResponseEntity.ok(productsService.create(product));
	}

	@PostMapping("/update")
	public ResponseEntity<Products> update(@RequestBody Products product) { //UUID needed.
		return ResponseEntity.ok(productsService.create(product));
	}
	
	@PostMapping("/delete/{uuid}")
	public void delete(@PathVariable UUID uuid) {
		productsService.delete(uuid);
	}
	
	@GetMapping("/search/{uuid}")
	public ResponseEntity<ProductsDto> search(@PathVariable UUID uuid) {
		Products product = productsService.search(uuid);
		return ResponseEntity.ok(productsConverter.entityToDto(product));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ProductsDto>> getAll(){
		List<Products> products = productsService.getAll();
		return ResponseEntity.ok(productsConverter.entityToDto(products));
	}
	
	@GetMapping("/getCategory")
	public ResponseEntity<List<ProductsDto>> getCategory(String category){
		List<Products> products = productsService.getByCategory(category);
		return ResponseEntity.ok(productsConverter.entityToDto(products));
	}
	
	@GetMapping("/getAllAdmin")
	public ResponseEntity<List<Products>> getAllAdmin(){
		return ResponseEntity.ok(productsService.getAll());
	}
}


