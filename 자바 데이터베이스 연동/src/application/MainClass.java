package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Category;
import model.Item;
import model.Member;
import model.OrderItem;
import model.Orders;
import service.CategoryService;
import service.ItemService;
import service.MemberService;
import service.OrderItemService;
import service.OrdersService;

public class MainClass extends Application{
		@Override
		public void start(Stage stage) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("./image/MenuBar.fxml"));
				stage.setScene(new Scene(root));
				stage.show();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	public static void main(String[] args) {
		launch(args);
		AppConfig appConfig = new AppConfig();
		MemberService memberService = appConfig.getMemberService();
		
		Member member = new Member();
//		System.out.println(member.toString()); //주소값 보고싶을때
//		member.setName("Abc");
//		memberService.save(member); //member에 데이터 넣어줌
		
		CategoryService categoryService = appConfig.getCategoryService();
		Category category = new Category();
//		category.setName("Price");
//		categoryService.save(category);
		
		ItemService itemService = appConfig.getItemService();
		Item item = new Item();
		
//		ArrayList<Member> memberList = memberService.getList();
//		Member getMem = memberService.getMember(1);
//		for(int i = 0; i < memberList.size(); i++) {
//			System.out.println("memberid = " + memberList.get(i).getId() + ", memberName = " + memberList.get(i).getName());
//		} //멤버 다 보고싶을때 구현
//		System.out.println("name = " + getMem.getName());
		
		OrdersService ordersService = appConfig.getOrdersService();
		Orders order = new Orders();
		
		OrderItemService orderItemService = appConfig.getOrderItemService();
		OrderItem orderItem = new OrderItem();
	}

}
