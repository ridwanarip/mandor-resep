package com.mandor.resep;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mandor.resep.model.Product;
import com.mandor.resep.repositories.ProductRepository;

@SpringBootApplication
public class MandorResepApplication {

	public static void main(String[] args) {
		SpringApplication.run(MandorResepApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner initProduct(ProductRepository productRepository) {
		return (args) -> {
			productRepository.save(new Product("baju", "distro", Long.parseLong("5000"), new Date()));
			productRepository.save(new Product("sempak", "distro", Long.parseLong("10000"), new Date()));
		};
	}

}
