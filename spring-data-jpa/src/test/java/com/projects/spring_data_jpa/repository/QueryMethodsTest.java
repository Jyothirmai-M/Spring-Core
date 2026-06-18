package com.projects.spring_data_jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.projects.spring_data_jpa.model.Product;

@SpringBootTest
class QueryMethodsTest {
	
	@Autowired
	ProductRepository productRepository;

	//@Test
	public void findByNameMethod() {
		Product product=productRepository.findByName("Product 3");
		System.out.println(product.toString());
	}
	
	@Test
	public void findByIdQueryMethod() {
		Product product=productRepository.findById(12L).get();
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getDescription());
	}

}
