package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="ProductInfo")  //Create table with name =ProductInfo

public class ProductInfo {
	
	
	@Id    //pid=Primary Key
	@GeneratedValue(strategy=GenerationType.IDENTITY)  //Autoincrement
	private int pid;
	private String pname;
	private String ptype;
	private String pmanufacturer;
	private int pprice;
	private int pwarranty;
	public ProductInfo(String pname, String ptype, String pmanufacturer, int pprice, int pwarranty) {
	
		
		this.pname = pname;
		this.ptype = ptype;
		this.pmanufacturer = pmanufacturer;
		this.pprice = pprice;
		this.pwarranty = pwarranty;
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
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public String getPmanufacturer() {
		return pmanufacturer;
	}
	public void setPmanufacturer(String pmanufacturer) {
		this.pmanufacturer = pmanufacturer;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public int getPwarranty() {
		return pwarranty;
	}
	public void setPwarranty(int pwarranty) {
		this.pwarranty = pwarranty;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", ptype=" + ptype + ", pmanufacturer=" + pmanufacturer
				+ ", pprice=" + pprice + ", pwarranty=" + pwarranty + "]";
	}
	public ProductInfo() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
