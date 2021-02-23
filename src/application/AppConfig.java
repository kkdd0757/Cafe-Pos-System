package application;
import repository.CategoryRepository;
import repository.ItemRepository;
import repository.MemberRepository;
import repository.OrderItemRepository;
import repository.OrdersRepository;
import service.CategoryService;
import service.ItemService;
import service.MemberService;
import service.OrderItemService;
import service.OrdersService;

public class AppConfig {
	
	private MemberRepository memberRepository = new MemberRepository();
	private MemberService memberService = new MemberService(memberRepository);
	
	private CategoryRepository categoryRepository = new CategoryRepository();
	private CategoryService categoryService = new CategoryService(categoryRepository);
	
	private ItemRepository itemRepository = new ItemRepository();
	private ItemService itemService = new ItemService(itemRepository);
	
	private OrdersRepository ordersRepository = new OrdersRepository();
	private OrdersService ordersService = new OrdersService(ordersRepository);
	
	private OrderItemRepository orderItemRepository = new OrderItemRepository();
	private OrderItemService orderItemService = new OrderItemService(orderItemRepository);
	
	//공유어디까지 반환형 메소드명
	public MemberService getMemberService() {
		return memberService;
	}
	public CategoryService getCategoryService() {
		return categoryService;
	}
	
	public ItemService getItemService() {
		return itemService;
	}
	public OrdersService getOrdersService() {
		return ordersService;
	}
	public OrderItemService getOrderItemService() {
		return orderItemService;
	}
}
