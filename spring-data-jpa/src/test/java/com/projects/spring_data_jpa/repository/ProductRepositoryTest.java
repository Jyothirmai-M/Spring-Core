package com.projects.spring_data_jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.projects.spring_data_jpa.model.Product;

@SpringBootTest //loads full application context so that we have access to all beans
class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;
	
	
	
	//using Junit ttestcase to test piece of code
	//@Test
	void saveMethod() {
		
		//create product
		Product product=new Product();
		product.setActive(true);
		product.setDescription("Product is good");
		product.setImageUrl("imageUrl");
		product.setName("Product 1");
		product.setPrice(new BigDecimal(100));
		product.setSku("200ABC");
		
		//save product
		Product savedProduct=productRepository.save(product);
		
		//display product
		System.out.println(savedProduct.getId());
		System.out.println(savedProduct.toString());
	}
	
	//@Test
	void updateWithSaveMethod() {
		//retrive by id
		Product product=productRepository.findById(1L).get();
		
		//update entity
		System.out.println(product.toString());
		product.setDescription("Product1 decription");
		product.setSku("365xyz");
		
		//save updated entity 
		productRepository.save(product);
	}

	
	//@Test
	void saveAllMethod() {
		Product product1=new Product();
		product1.setActive(true);
		product1.setDescription("Product2 Desc");
		product1.setImageUrl("imageUrl");
		product1.setName("Product 2");
		product1.setPrice(new BigDecimal(100));
		product1.setSku("200ABC");
		
		
		Product product2=new Product();
		product2.setActive(true);
		product2.setDescription("Product3 Desc");
		product2.setImageUrl("imageUrl");
		product2.setName("Product 3");
		product2.setPrice(new BigDecimal(100));
		product2.setSku("200ABC");
		
		
		productRepository.saveAll(List.of(product1,product2));
		
	}
	
	// @Test
	void findAllMethod() {
		List<Product> products=productRepository.findAll();
		products.stream().forEach(System.out::println);
	}
	
	//@Test
	void deleteByIdMethod() {
		productRepository.deleteById(3L);
		System.out.println("deleted successfully!");
	}
	
	//@Test
	void deleteMethod() {
		Product product=productRepository.findById(4L).get();
		productRepository.delete(product);
		System.out.println("deleted successfully!");
	}
	
	//@Test
	void deleteAllMethod() {
		productRepository.deleteAll();
		System.out.println("deleted successfully!");
	}
	
	//@Test
	void deleteAllMethodwithEntities() {
		Product product1=productRepository.findById(10L).get();
		Product product2=productRepository.findById(11L).get();
		
		productRepository.deleteAll(List.of(product1,product2));
		System.out.println("deleted successfully!");		
	}
	
	//@Test
	void countMethod() {
		Long count=productRepository.count();
		System.out.println("count of products:"+count);
	}
	
	//@Test
	void existsByIdMethod() {
		boolean result=productRepository.existsById(1L);
		System.out.println(result);
	}
}


