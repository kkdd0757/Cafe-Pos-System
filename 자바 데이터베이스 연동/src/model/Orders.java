package model;

import java.sql.Timestamp;

public class Orders {
	private int id;
	private int memberId;
	private Timestamp orderDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId=memberId;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	
}

