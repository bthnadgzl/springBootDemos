package com.demo.customers.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.customers.entity.Customers;
import com.demo.customers.repository.CustomersDao;

@Service
public class CustomersServiceImpl implements CustomersService{
	
	@Autowired CustomersDao customersDao;
	
	@Override
	public Customers create(Customers customer) {
		return customersDao.save(customer);
	}
	@Override
	public Customers update(Customers customer) {
		
		return customersDao.save(customer);
	}
	@Override
	public Customers search(long identityNo) {
		return customersDao.findByIdentityNo(identityNo);
	}
	@Override
	public void delete(UUID uuid) {
		customersDao.deleteById(uuid);
	}
	@Override
	public void permissionTrue(UUID uuid) {
		Customers customer = customersDao.findById(uuid).get();
		customer.setPermission(true);
		customersDao.save(customer);
	}
	@Override
	public void permissionFalse(UUID uuid) {
		Customers customer = customersDao.findById(uuid).get();
		customer.setPermission(false);
		customersDao.save(customer);
	}
	@Override
	public void checkPermission(UUID uuid) throws Exception {
		Customers customer = customersDao.findById(uuid).get();
		if(customer.isPermission() != true) {
			throw new Exception("This customer have no permission.");
		}
		
	}
	@Override
	public Page<Customers> getAll(Optional<Integer> page, Optional<String> sortBy){
		return customersDao.findAll(PageRequest.of(page.orElse(0), 5, Sort.Direction.ASC, sortBy.orElse("name")));
	}
	public UUID getId(long identityNo) {
		Customers customer = customersDao.findByIdentityNo(identityNo);
		return customer.getCustomerId();
	}
	@Override
	public Customers searchByUuid(UUID uuid) {
		return customersDao.findById(uuid).get();
	}
	
	
}
