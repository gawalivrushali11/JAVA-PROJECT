package com.example.demo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface ProductDB extends JpaRepository<ProductInfo,Integer>{
	public ProductInfo findBypname(String pname);   //findBy(name of property that you want to find ex pname,pprice etc)
	public List<ProductInfo> findBypmanufacturer(String mname);
	
	 
	
	@Query("SELECT p FROM  ProductInfo p where p.pwarranty<:year")
	List<ProductInfo> findBypwarranty(int year);
	
	
	@Query("SELECT sum(p.pprice) FROM  ProductInfo p")
	int findBypprice();
	
	 @Query("SELECT p FROM ProductInfo p WHERE pname LIKE %:text% OR ptype LIKE %:text% OR pmanufacturer LIKE %:text%")
	  List<ProductInfo> findProductsByText(String text);
	 
	 @Transactional
	 @Modifying
	 @Query("UPDATE ProductInfo p SET  p.pprice = ?2 WHERE p.pid = ?1")
	 int updatePrice(int proid,int price);

}
