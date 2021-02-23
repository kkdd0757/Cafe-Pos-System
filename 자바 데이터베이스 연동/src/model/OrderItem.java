package model;

public class OrderItem {
	private int id;
	private int orderId;
	private int itemId;
	private int orderPrice;
	private int count;
	
	public OrderItem(int orderId, int itemId, int orderPrice, int count) {
		this.orderId = orderId;
		this.itemId = itemId;
		this.orderPrice =orderPrice;
		this.count = count;
	}
	public OrderItem() {
		
	}	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId=orderId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public long getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice=orderPrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count=count;
	}
}
