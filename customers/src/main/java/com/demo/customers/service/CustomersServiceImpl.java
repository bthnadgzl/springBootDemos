package com.demo.customers.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Customers> getAll(){
		return (List<Customers>) customersDao.findAll();
	}
	public UUID getId(long identityNo) {
		Customers customer = customersDao.findByIdentityNo(identityNo);
		return customer.getCustomerId();
	}
	
	
}
