package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customexception.NoProductEntityFoundException;
import com.app.customexception.ProductEntityFoundException;
import com.app.entities.Admin;

import com.app.entities.Product;
import com.app.entities.User;
import com.app.repository.AdminRepository;

import com.app.repository.ProductRepository;
import com.app.repository.UserRepository;

@Service
public class AdminService {
	@Autowired
	 private ProductRepository productRepository;
	
	@Autowired
	 private AdminRepository adminRepository;
	
	
	
	@Autowired
	 private UserRepository  userRepository;
	
	
	
	
	public Product addHomeProduct(Product newproduct) {	
		
		String pname=newproduct.getPname();
		Product product1=productRepository.findByPname(pname);
		
	
	if(product1!=null) {
		int id=product1.getPid();
		throw new ProductEntityFoundException("The product with name: :"
				+ " "+pname+" is already present having id"+id);
	}
	else if(product1==null) {
		
		Product savedproduct=productRepository.save(newproduct);
		return savedproduct;
	}
	return null;
	}	


	
	
	
	
	
	public Admin addAdmin(Admin admin) {
		Admin savedadmin=adminRepository.save(admin);
		return savedadmin;
	}

	public List<Product> getAllProduct() {
		List<Product> products=(List<Product>) productRepository.findAll();
		return  products;
	}

	public List<User> getAllUser() {
		List<User> users	=(List<User>) userRepository.findAll();
		return  users	;
	}

	public Product deleteProduct(int id) {
		productRepository.deleteById(id);
		return null;
	}

	public Product updateProduct(Product product, int id) {
		if(id==product.getPid()) {
			return productRepository.save(product);
		}
		return null;
	}

}
