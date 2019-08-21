package com.mandor.resep.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
	
	@DateTimeFormat(iso = ISO.DATE)
	private Date expired;
	
	public Product() {
	}
	
	public Product(String name, String brand, Long price, Date expired) {
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.expired = expired;
	}
}
