package com.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.entities.Category;



public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
