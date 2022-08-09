package com.demo.customers.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.demo.customers.entity.Customers;


public interface CustomersService {
	
	public Customers create(Customers customer);
	public Customers update(Customers customer);
	public Customers search(long identityNo);
	public Customers searchByUuid(UUID uuid);
	public void delete(UUID uuid);
	public void permissionTrue(UUID uuid);
	public void permissionFalse(UUID uuid);
	public boolean getPermission(UUID uuid);
	public Page<Customers> getAll(Optional<Integer> page, Optional<String> sortBy);
	public UUID getId(long identityNo);

}
