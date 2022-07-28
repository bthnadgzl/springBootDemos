package com.demo.customers.service;

import java.util.List;
import java.util.UUID;

import com.demo.customers.entity.Customers;


public interface CustomersService {
	
	public Customers create(Customers customer);
	public Customers update(Customers customer);
	public Customers search(long identityNo);
	public void delete(UUID uuid);
	public void permissionTrue(UUID uuid);
	public void permissionFalse(UUID uuid);
	public List<Customers> getAll();
	public UUID getId(long identityNo);

}
