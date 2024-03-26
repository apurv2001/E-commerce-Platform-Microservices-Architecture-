package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.customexception.NoProductEntityFoundException;
import com.app.entities.Admin;
import com.app.entities.Product;
import com.app.entities.User;
import com.app.entities.UserCart;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	 private UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User suser=userService.addUser(user);
		return new ResponseEntity<User>(suser, HttpStatus.CREATED);
	}
	
	@GetMapping("/getproducts")
	public ResponseEntity<List<Product>> addAllProduct(){
		List<Product> products=userService.addAllProduct();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
	Product product = userService.getProduct(id);
		if(product==null) {
			
			throw new NoProductEntityFoundException("The product with id : "+id+" not found");
		}

		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@PostMapping("/{id}/{qty}")
	public ResponseEntity<UserCart> addToCart(@PathVariable("id") int id,@PathVariable("qty") int qty) {
		UserCart productadded	=userService.addToCart(id,qty);
		return new ResponseEntity<UserCart>( productadded, HttpStatus.OK);
	
	}

}
