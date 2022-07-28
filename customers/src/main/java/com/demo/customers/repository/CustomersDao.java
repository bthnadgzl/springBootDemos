package com.demo.customers.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.customers.entity.Customers;

@Repository
public interface CustomersDao extends CrudRepository<Customers,UUID>{
	Customers findByIdentityNo(long identityNo);
}
