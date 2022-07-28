package com.demo.customers.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Entity
@Table(name="customers")
@Data
@NoArgsConstructor
public class Customers {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID" , strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="customer", updatable=false, nullable=false, columnDefinition = "BINARY(16)")
	@JsonProperty("customerid")
	private UUID customerId;
	
	@Column(updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate = new Date();
	
	
	@Column(name="identity_no")
	@JsonProperty("identityNo")
	private long identityNo;
	
	@Column(name="name")
	@JsonProperty("name")
	private String name;
	
	@Column(name="surname")
	@JsonProperty("surname")
	private String surname;
	
	@Column(name="age")
	@JsonProperty("age")
	private int age;

	@Column(name="adress")
	@JsonProperty("adress")
	private String adress;
	
	@Column(name="permission")
	@JsonProperty("permission")
	private boolean permission;
	
	

	
	public Customers(long identityNo, String name, String surname, int age, String adress) {
		this.identityNo = identityNo;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.adress = adress;
	}
	
	
	
}
