package com.mandor.resep.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity (name = "t_product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String brand;
	
	private Long price;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date expired;
		
	public Product(String name, String brand, Long price, Date expired) {
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.expired = expired;
	}
}
