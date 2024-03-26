package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Admin;
import com.app.entities.Product;
import com.app.entities.User;
import com.app.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	 private AdminService  adminService;
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin){
		Admin sadmin=adminService.addAdmin(admin);
		return new ResponseEntity<Admin>(sadmin, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<Product> addHomeProduct(@RequestBody Product newproduct){
		Product sproduct=adminService.addHomeProduct(newproduct);
		return new ResponseEntity<Product>(sproduct, HttpStatus.CREATED);
	}
	
	@GetMapping("/getproducts")
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> products=adminService.getAllProduct();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@GetMapping("/getusers")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> suser=adminService.getAllUser();
		return new ResponseEntity<List<User>>(suser, HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") int id) {
	   Product product = adminService.deleteProduct(id);
	   if(product==null) {
		
		   return new ResponseEntity(HttpStatus.NOT_FOUND);
	   }
	   return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") int id) {
		Product productupdated=adminService.updateProduct(product, id);
		return  new ResponseEntity<Product>(productupdated, HttpStatus.OK);
		
	}

}
