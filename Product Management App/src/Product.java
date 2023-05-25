
public class Product {
	String productname;
	String type;
	String manufacturer;
	int price;
	int warranty;
	
	public Product(String productname, String type, String manufacturer, int price, int warranty) {
		
		this.productname = productname;
		this.type = type;
		this.manufacturer = manufacturer;
		this.price = price;
		this.warranty = warranty;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getmanufacturer() {
		return manufacturer;
	}

	public void setmanufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getprice() {
		return price;
	}

	public void setprice(int price) {
		this.price = price;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	@Override
	public String toString() {
		return "Product [productname=" + productname + ", type=" + type + ", manufacturer=" + manufacturer + ", price=" + price
				+ ", warranty=" + warranty + "]";
	}
	
	
	
	
	
	

}
