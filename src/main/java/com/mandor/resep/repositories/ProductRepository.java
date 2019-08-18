package com.mandor.resep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mandor.resep.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
