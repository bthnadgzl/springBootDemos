package com.demo.customers.service;

import java.util.List;
import java.util.UUID;

import com.demo.customers.entity.Customers;


public interface CustomersService {
	
	public void create(Customers customer);
	public void update(Customers customer);
	public Customers search(UUID uuid);
	public void delete(UUID uuid);
	public void permissionTrue(UUID uuid);
	public void permissionFalse(UUID uuid);
	public List<Customers> getAll();

}
