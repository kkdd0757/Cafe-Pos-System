package service;

import java.util.ArrayList;

import model.Orders;
import repository.OrdersRepository;

public class OrdersService {
	final OrdersRepository ordersRepository;
	
	public OrdersService(OrdersRepository ordersRepository) {
		this.ordersRepository = ordersRepository;
	}
	
	public int save(int memberId) {
		return ordersRepository.createOrder(memberId);
	}
	
	public ArrayList<Orders> getList(){
		return ordersRepository.getList();
	}
	
	public Orders getOrders(int id) {
		return ordersRepository.getOrders(id);
	}
}
