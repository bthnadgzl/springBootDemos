package com.demo.customers.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.demo.customers.dto.CustomersDto;
import com.demo.customers.entity.Customers;

@Component
public class CustomersConverter {

	public CustomersDto entityToDto(Customers customer) {
		CustomersDto customerDto = new CustomersDto();
		customerDto.setIdentityNo(customer.getIdentityNo());
		customerDto.setName(customer.getName());
		customerDto.setSurname(customer.getAdress());
		customerDto.setAge(customer.getAge());
		customerDto.setAdress(customer.getAdress());	
		return customerDto;	
	}
	
	public List<CustomersDto> entityToDto(List<Customers> customer) {
		return customer.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	
	public Customers dtoToEntity(CustomersDto customerDto) {
		Customers customer = new Customers();
		customer.setIdentityNo(customerDto.getIdentityNo());
		customer.setName(customerDto.getName());
		customer.setSurname(customerDto.getAdress());
		customer.setAge(customerDto.getAge());
		customer.setAdress(customerDto.getAdress());	
		return customer;
	}
	
	public List<Customers> dtoToEntity(List<CustomersDto> customerDto) {
		return customerDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
	
	
	
}