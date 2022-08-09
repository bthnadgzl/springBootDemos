package com.demo.customers.controller;

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

import com.demo.customers.converter.CustomersConverter;
import com.demo.customers.dto.CustomersDto;
import com.demo.customers.entity.Customers;
import com.demo.customers.service.CustomersService;

@RestController
@RequestMapping("/api_customers")
public class CustomersController {
	
	@Autowired CustomersConverter customersConverter;
	@Autowired CustomersService customersService;
	
	
	@PostMapping
	public ResponseEntity<CustomersDto> create(@RequestBody CustomersDto customerDto) {
		Customers customer = customersConverter.dtoToEntity(customerDto);
		customersService.create(customer);
		return ResponseEntity.ok(customerDto);
	}
	
	@PutMapping
	public ResponseEntity<Customers> update(@RequestBody Customers customer) { //UUID needed.
		return ResponseEntity.ok(customersService.update(customer));
	}
	
	@GetMapping("/search/{identityNo}")
	public ResponseEntity<CustomersDto> search(@PathVariable long identityNo) {
		Customers customer = customersService.search(identityNo);
		return ResponseEntity.ok(customersConverter.entityToDto(customer));
	}
	@GetMapping("/search_by_uuid/{uuid}")
	public ResponseEntity<Customers> searchByUuid(@PathVariable UUID uuid){
		return ResponseEntity.ok(customersService.searchByUuid(uuid));
	}
	
	@DeleteMapping("/{uuid}")
	public void delete(@PathVariable UUID uuid) { //delete does not return data.
		customersService.delete(uuid);
	}
	
	@PutMapping("/permission_true/{uuid}")
	public void permissionTrue(@PathVariable UUID uuid) {
		customersService.permissionTrue(uuid);
	}
	
	@PutMapping("/permission_false/{uuid}")
	public void permissionFalse(@PathVariable UUID uuid) {
		customersService.permissionFalse(uuid);
	}
	
	@GetMapping //limit ve filtre koyulmalı
	public ResponseEntity<Page<Customers>> getAll(Optional<Integer> page, Optional<String> sortBy){
		Page<Customers> customers = customersService.getAll(page,sortBy);
		return ResponseEntity.ok(customers);
	}
	@GetMapping("/get_id/{identityNo}")
	public UUID getId(@PathVariable long identityNo) {
		return customersService.getId(identityNo);
	}

}
