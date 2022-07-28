package com.demo.customers.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/apiCustomers")
public class CustomersController {
	
	@Autowired CustomersConverter customersConverter;
	@Autowired CustomersService customersService;
	
	
	@PostMapping("/create")
	public ResponseEntity<Customers> create(@RequestBody CustomersDto customerDto) {
		Customers customer = customersConverter.dtoToEntity(customerDto);
		return ResponseEntity.ok(customersService.create(customer));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Customers> update(@RequestBody Customers customer) { //Id ile birlikte girilmez ise yeni kayıt oluşturur.
		return ResponseEntity.ok(customersService.update(customer));
	}
	
	@GetMapping("/search/{identityNo}")
	public ResponseEntity<CustomersDto> search(@PathVariable long identityNo) {
		Customers customer = customersService.search(identityNo);
		return ResponseEntity.ok(customersConverter.entityToDto(customer));
	}
	
	@PostMapping("/delete/{uuid}")
	public void delete(@PathVariable UUID uuid) { //delete does not return data.
		customersService.delete(uuid);
	}
	
	@PostMapping("/permTrue/{uuid}")
	public void permissionTrue(@PathVariable UUID uuid) {
		customersService.permissionTrue(uuid);
	}
	
	@PostMapping("/permFalse/{uuid}")
	public void permissionFalse(@PathVariable UUID uuid) {
		customersService.permissionFalse(uuid);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CustomersDto>> getAll(){
		List<Customers> customers = customersService.getAll();
		return ResponseEntity.ok(customersConverter.entityToDto(customers));
	}
	@GetMapping("/getId/{identityNo}")
	public UUID getId(@PathVariable long identityNo) {
		return customersService.getId(identityNo);
	}

}
