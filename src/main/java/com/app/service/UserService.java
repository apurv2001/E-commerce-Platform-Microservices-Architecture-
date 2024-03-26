package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customexception.InSufficientEntityFoundException;
import com.app.customexception.NoProductEntityFoundException;
import com.app.entities.Admin;
import com.app.entities.Product;
import com.app.entities.User;
import com.app.entities.UserCart;
import com.app.repository.ProductRepository;
import com.app.repository.UserCartRepository;
import com.app.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	 private ProductRepository productRepository;
	
	@Autowired
	 private UserRepository  userRepository;
	
	@Autowired
	 private UserCartRepository userCartRepository;
	

	public List<Product> addAllProduct() {
		List<Product> products= (List<Product>) productRepository.findAll();
		return products;
	}

	public User addUser(User user) {
		User saveduser=userRepository.save(user);
		return saveduser;
	}

	public Product getProduct(int id) {
		Optional<Product> optional=productRepository.findById(id);
		if(optional.isPresent()) {
			  return optional.get();
		  }
		  return null;
		}

	public UserCart addToCart(int id,int qty) {
		Optional<Product> optional=productRepository.findById(id);
	Product product	=optional.get();
	Product product1	=optional.get();
	int a=product.getPqty();
	int x=product.getPid();
	int y=product.getPprice();
    String name=product.getPname();
	if(a<qty) {

		throw new InSufficientEntityFoundException("Please enter valid Quantity");
	}
	else {
		UserCart p= new UserCart();
		//Product p=new Product();
		p.setPqty(qty);
		p.setPname(name);
		p.setPprice(y);
		p.setPid(x);
		p.setTotal(y*qty);
		UserCart productadded=userCartRepository.save(p);
		product1.setPqty(a-qty);
		Product productupdated=productRepository.save(product1);
		return productadded;
	}
	
	
	}
	

}
