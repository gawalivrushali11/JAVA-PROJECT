package com.example.demo;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServices {
	
	
	@Autowired
	ProductDB db;
	
	public void addProduct(ProductInfo p)
	{
		db.save(p);
	}
	
	public List<ProductInfo> getAllProducts()
	{
			return db.findAll();
	}
	
	public void deleteAllProducts()
	{
			db.deleteAll();
	}
	
	public Optional<ProductInfo> getProduct(int pid)
	{
		return db.findById(pid);
		
				
		
	}
	public ProductInfo getByProductName(String pname)
	{
		return db.findBypname(pname);
		
				
		
	}
	
	public List<ProductInfo> getByManufacturer(String mname)
	{
		List<ProductInfo> plt=new ArrayList<>();
		
		plt=db.findBypmanufacturer(mname);
//		for(Product p:plist)
//		{
//			if(p.getmanufacturer().equalsIgnoreCase(mname))
//			{
//				plt.add(p);
//			}
//		}
//		
		return plt;
		
	}
	
	public List<ProductInfo> getOutOfWarrantyProducts()
	{
		List<ProductInfo> plt=new ArrayList<>();
		LocalDate currentDate = LocalDate.now();
		 int year=currentDate.getYear();
		plt=db.findBypwarranty(year);
		
		return plt;
	}
	
	public int totalPriceProduct()
	{
		
		int total=db.findBypprice();
		

		return total;
	}
	
	
	
	public List<ProductInfo> getProductsWithText(String text)
	{
		List<ProductInfo> plt=new ArrayList<>();
		
		plt=db.findProductsByText(text);
		
		return plt;
	}
	
	public void updateProductPrice(int pid,int price)
	{
		int rows =db.updatePrice(pid,price);
		System.out.println("Rows Affetcted:"+rows);
	
	}
	
	
	
	
}
