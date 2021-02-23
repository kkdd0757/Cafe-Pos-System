package service;

import java.util.ArrayList;

import model.Item;
import repository.ItemRepository;

public class ItemService {
	final ItemRepository itemRepository;
	
	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	public void save(Item item) {
		itemRepository.join(item);
	}
	
	public ArrayList<Item> getList(){
		return itemRepository.getList();
	}
	
	public Item getItem(int id) {
		return itemRepository.getItem(id);
	}
	
	public void minusStockQuantity(int id, int stockQuantity) {
		 itemRepository.minusStockQuantity(id, stockQuantity);
	}
}
