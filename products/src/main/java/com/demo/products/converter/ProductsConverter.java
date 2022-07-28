package com.demo.products.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.demo.products.dto.ProductsDto;
import com.demo.products.entity.Products;

@Component
public class ProductsConverter {
	
	public ProductsDto entityToDto(Products product) {
		ProductsDto productDto = new ProductsDto();
		productDto.setName(product.getName());
		productDto.setColor(product.getColor());
		productDto.setCategory(product.getCategory());
		productDto.setPrice(product.getPrice());
		return productDto;	
	}
	
	public List<ProductsDto> entityToDto(List<Products> product) {
		return product.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	
	public Products dtoToEntity(ProductsDto productDto) {
		Products product = new Products();
		product.setName(productDto.getName());
		product.setColor(productDto.getColor());
		product.setCategory(productDto.getCategory());
		product.setPrice(productDto.getPrice());
		return product;
	}
	
	public List<Products> dtoToEntity(List<ProductsDto> productDto) {
		return productDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
	
	
}
