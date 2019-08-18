package com.mandor.resep.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mandor.resep.model.Product;
import com.mandor.resep.repositories.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public List<Product> listAll() {
		return repo.findAll();
	}
	
	public void save(Product product) {
		repo.save(product);
	}
	
	public Optional<Product> getProduct(Long id) {
		return repo.findById(id);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
