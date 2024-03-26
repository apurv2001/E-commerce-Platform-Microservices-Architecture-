package com.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.entities.Product;
import com.app.entities.User;
import com.app.entities.UserCart;

public interface UserCartRepository extends CrudRepository<UserCart, Integer> {

}
