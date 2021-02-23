package model;

public class Item {
	private int id;
	private String name;
	private int price;
	private int stockQuantity;
	private int category_id;
	
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
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getStockQuantity() {
		return stockQuantity;
	}
	
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	public int getCategoryId() {
		return category_id;
	}
	
	public void setCategoryId(int category_id) {
		this.category_id = category_id;
	}
}
