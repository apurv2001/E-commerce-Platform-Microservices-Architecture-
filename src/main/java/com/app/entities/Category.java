package com.app.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Category {
	@Id
	private int cid;
	private String title;
	
	
	

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Category(int cid, String title) {
		super();
		this.cid = cid;
		this.title = title;

	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}





	

}
