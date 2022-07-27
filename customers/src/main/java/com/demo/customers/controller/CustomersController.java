package com.demo.customers.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.customers.entity.Customers;
import com.demo.customers.service.CustomersService;

@RestController
@RequestMapping("/apiCustomers")
public class CustomersController {
	
	private CustomersService customersService;
	
	@Autowired
	public CustomersController(CustomersService customersService) {
		this.customersService = customersService;
	}
	
	@PostMapping("/create")
	public void create(@RequestBody Customers customer) {
		customersService.create(customer);
	}
	@PostMapping("/update")
	public void update(@RequestBody Customers customer) {
		customersService.update(customer);
	}
	@GetMapping("/search/{uuid}")
	public Customers search(@PathVariable UUID uuid) {
		return customersService.search(uuid);
	}
	@PostMapping("/delete/{uuid}")
	public void delete(@PathVariable UUID uuid) {
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
	public List<Customers> getAll(){
		return customersService.getAll();
	}

}
