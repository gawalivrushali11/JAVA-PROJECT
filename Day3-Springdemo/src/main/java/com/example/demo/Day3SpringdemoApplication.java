package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class Day3SpringdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Day3SpringdemoApplication.class, args);
		ProductServices ps=context.getBean(ProductServices.class);

		
		
		System.out.println("--------Insert All Products..............");
		
		ps.addProduct(new ProductInfo("Dell Inspiron","Laptop","Dell",100000,2030));
		ps.addProduct(new ProductInfo("Vivo HP","Laptop","HP",500000,2022));
		ps.addProduct(new ProductInfo("Apple","Laptop","Apple",1000000,2025));
		ps.addProduct(new ProductInfo("Lenovo","Laptop","HP",60000,2015));
		ps.addProduct(new ProductInfo("Netbook","Laptop","Apple",400000,2040));
		ps.addProduct(new ProductInfo("Macbook","Laptop","Apple",800000,2040));

		System.out.println("--------Fetch and Display All Products..............");
		List<ProductInfo> plt=new ArrayList<>();
		plt=ps.getAllProducts();
		for(ProductInfo p:plt)
		{
			System.out.println(p);
		}
		
		System.out.println("--------get product by id..............");
		Optional<ProductInfo> p=ps.getProduct(50);
		System.out.println(p);
		
		
		
		System.out.println("--------get product by name..............");
		ProductInfo p1=ps.getByProductName("Apple");
		System.out.println(p1);
		
		System.out.println("--------get product by manufacturere name..............");
		List<ProductInfo> p2=ps.getByManufacturer("HP");
		p2.stream().forEach(System.out::println);
		
		System.out.println("--------get out of warranty product.............");
		List<ProductInfo> p3=ps.getOutOfWarrantyProducts();
		p3.stream().forEach(System.out::println);
		
		System.out.println("--------get total price of product.............");
		System.out.println(ps.totalPriceProduct());
		
		System.out.println("--------get all the products contaning text in name,type,manufacturere name.............");
		List<ProductInfo> p4=ps.getProductsWithText("HP");
		p4.stream().forEach(System.out::println);
		
		System.out.println("--------Update Product Price.............");
		ps.updateProductPrice(1,560409);

//		System.out.println("--------Delete  All Products..............");
//		ps.deleteAllProducts();
		
	}

}
