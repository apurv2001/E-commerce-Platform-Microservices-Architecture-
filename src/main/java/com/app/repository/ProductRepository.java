package com.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	public Product findByPname(String name);
	

}
