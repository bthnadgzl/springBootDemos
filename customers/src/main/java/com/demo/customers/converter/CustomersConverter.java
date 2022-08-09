package com.demo.customers.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.customers.dto.CustomersDto;
import com.demo.customers.entity.Customers;

@Component
public class CustomersConverter {
	
	@Autowired ModelMapper mapper;

	public CustomersDto entityToDto(Customers customer) {
		CustomersDto customerDto = mapper.map(customer, CustomersDto.class);	
		return customerDto;	
	}
	
	public List<CustomersDto> entityToDto(List<Customers> customer) {
		return customer.stream().map(x -> entityToDto(x)).collect(Collectors.toList()); //we should use for lists
	}
	
	
	public Customers dtoToEntity(CustomersDto customerDto) {
		Customers customer = mapper.map(customerDto, Customers.class);
		return customer;
	}
	
	public List<Customers> dtoToEntity(List<CustomersDto> customerDto) {
		return customerDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
	
	
	
}