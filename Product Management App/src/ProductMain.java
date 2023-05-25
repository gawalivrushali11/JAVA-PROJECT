import java.util.List;

public class ProductMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProductServices ps=new ProductServices();
		ps.addProduct(new Product("Dell Inspiron","Laptop","Dell",100000,2030));
		ps.addProduct(new Product("Vivo HP","Laptop","HP",500000,2022));
		ps.addProduct(new Product("Apple","Laptop","Apple",1000000,2025));
		ps.addProduct(new Product("Lenovo","Laptop","HP",60000,2015));
		ps.addProduct(new Product("Netbook","Laptop","Apple",400000,2040));
		ps.addProduct(new Product("Macbook","Laptop","Apple",800000,2040));
		//Get all the products
		
		System.out.println("===============Print all Products=========================");
		List<Product> pl=ps.getAllProducts();
		pl.stream().forEach(System.out::println);
		
		System.out.println("===============Find by product name=========================");
		String pname="Netbook";
		Product p=ps.getProduct(pname);
		System.out.println(p);
		
		System.out.println("===============Find product by text=========================");
		
		List<Product> pListText=ps.getProductsWithText("HP");
		for(Product p1:pListText)
		{
			System.out.println(p1);
		}
		
		System.out.println("===============Find product out of warranty=========================");
		List<Product> pltwarranty=ps.getOutOfWarrantyProducts();
		for(Product p1:pltwarranty)
		{
			System.out.println(p1);
		}
		
		System.out.println("===============Find product by Manufacturer Name=========================");
		List<Product> pltmanufact=ps.getByManufacturer("Dell");
		for(Product p1:pltmanufact)
		{
			System.out.println(p1);
		}
		
		System.out.println("===============Find Total Product Price=========================");
		int total=ps.totalPriceProduct();
		System.out.println("Total Price:"+total);
		
		
	}

}
