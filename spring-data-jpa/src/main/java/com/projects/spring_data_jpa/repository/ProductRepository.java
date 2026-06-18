package com.projects.spring_data_jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.spring_data_jpa.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	public Product findByName(String s);
	public Optional<Product> findById(Long id);
}
