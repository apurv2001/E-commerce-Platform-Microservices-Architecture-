package com.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="CartTable")
public class UserCart {
	
	@Id
	private int pid;
	private String pname;
	private int pprice;
	private int pqty;
	private int total;

	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public UserCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserCart(int pid, String pname, int pprice, int pqty) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.pqty = pqty;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public int getPqty() {
		return pqty;
	}
	public void setPqty(int pqty) {
		this.pqty = pqty;
	}
	

}
