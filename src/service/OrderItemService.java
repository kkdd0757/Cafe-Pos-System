package service;

import java.util.ArrayList;

import model.OrderItem;
import repository.OrderItemRepository;

public class OrderItemService {
	final OrderItemRepository orderItemRepository;
	
	public OrderItemService(OrderItemRepository orderItemRepository) {
		this.orderItemRepository = orderItemRepository;
	}
	public void save(OrderItem orderItem) {
		orderItemRepository.createOrderItem(orderItem);
	}
	
	public ArrayList<OrderItem> getList(){
		return orderItemRepository.getList();
	}
	public OrderItem orderItem(int id) {
		return orderItemRepository.getOrderItem(id);
	}
}
