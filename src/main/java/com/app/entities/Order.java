package com.app.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Order {
	@Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
	private int oid;
	
	

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int oid) {
		super();
		this.oid = oid;
		
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	

	

}
