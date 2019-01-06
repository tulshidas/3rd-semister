package lab;

public class Product {
	private int id;
	private String name;
	private Category category;
	private double price;
	private double quantity;
	
	public Product(int id,String name,Category category,double price,double quantity) {
		this.setId(id);
		this.setName(name);
		this.setCategory(category);
		this.setPrice(price);
		this.setQuantity(quantity);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	
}
