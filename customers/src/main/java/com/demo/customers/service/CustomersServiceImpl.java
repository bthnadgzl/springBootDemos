package com.demo.customers.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.customers.entity.Customers;
import com.demo.customers.repository.CustomersDto;

@Service
public class CustomersServiceImpl implements CustomersService{
	private CustomersDto customersDto;
	
	@Autowired
	public CustomersServiceImpl(CustomersDto customersDto) {
		this.customersDto = customersDto;
	}
	
	@Override
	public void create(Customers customer) {
		customersDto.save(customer);
	}
	@Override
	public void update(Customers customer) {
		customersDto.save(customer);
	}
	@Override
	public Customers search(UUID uuid) {
		return customersDto.findById(uuid).get();
	}
	@Override
	public void delete(UUID uuid) {
		customersDto.deleteById(uuid);
	}
	@Override
	public void permissionTrue(UUID uuid) {
		Customers customer = customersDto.findById(uuid).get();
		customer.setPermission(true);
		customersDto.save(customer);
	}
	@Override
	public void permissionFalse(UUID uuid) {
		Customers customer = customersDto.findById(uuid).get();
		customer.setPermission(false);
		customersDto.save(customer);
	}
	@Override
	public List<Customers> getAll(){
		return (List<Customers>) customersDto.findAll();
	}
	
}
