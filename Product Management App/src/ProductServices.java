import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServices {
	
	List<Product> plist=new ArrayList<Product>();
	
	public void addProduct(Product p)
	{
		plist.add(p);
	}
	
	public List<Product> getAllProducts()
	{
			return plist;
	}
	public Product getProduct(String pname)
	{
		for(Product p:plist)
		{
			
			if(p.getProductname().equals(pname))
				return p;
		}
		return null;
	}
	
	public List<Product> getProductsWithText(String text)
	{
		List<Product> plt=new ArrayList<>();
		for(Product p:plist)
		{
			if(p.getProductname().contains(text)||p.getType().contains(text)||p.getmanufacturer().contains(text))
			{
				plt.add(p);
			}
			
		}
		
		return plt;
	}
	
	public List<Product> getOutOfWarrantyProducts()
	{
		List<Product> plt=new ArrayList<>();
		plt=plist.stream().filter(p->p.getWarranty()<2023).collect(Collectors.toList());
//		for(Product p:plist)
//		{
//			if(p.getWarranty()<2023)
//			{
//				plt.add(p);
//			}
//		}
		
		return plt;
	}
	
	public int totalPriceProduct()
	{
		int total = plist.stream().collect(Collectors.summingInt(Product::getprice));
//		for(Product p:plist)
//		{
//			total=total+p.getprice();
//	}
		return total;
	}
	
	public List<Product> getByManufacturer(String mname)
	{
		List<Product> plt=new ArrayList<>();
		
		plt=plist.stream().filter(p->p.getmanufacturer().equalsIgnoreCase(mname)).collect(Collectors.toList());
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
}
