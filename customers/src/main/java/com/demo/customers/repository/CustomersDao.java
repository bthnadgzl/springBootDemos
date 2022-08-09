package com.demo.customers.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.demo.customers.entity.Customers;

@Repository
public interface CustomersDao extends PagingAndSortingRepository<Customers,UUID>{
	Customers findByIdentityNo(long identityNo);
}
