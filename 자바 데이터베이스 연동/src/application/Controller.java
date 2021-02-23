package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Item;
import model.OrderItem;
import repository.ItemRepository;
import repository.OrderItemRepository;
import repository.OrdersRepository;
import service.ItemService;
import service.OrderItemService;
import service.OrdersService;

public class Controller implements Initializable{
	private int x;
	private int result=0;
	ItemService item; 
	OrderItemService orderItem;
	OrdersService orderService;
	ArrayList<String> btnList;
	LinkedHashMap<String, Item> btnmap;
	LinkedHashMap<Integer, Integer> countMap; 
	ArrayList<Item> arr;

	public Controller() {
		item = new ItemService(new ItemRepository());
		btnList = new ArrayList<String>();
		btnmap = new LinkedHashMap<String, Item>();
		arr= item.getList();
		orderService = new OrdersService(new OrdersRepository());
		orderItem = new OrderItemService(new OrderItemRepository());
		
		countMap = new LinkedHashMap<>();
		for(int i=0;i<arr.size();i++) {			
			btnList.add("item"+ i);
			btnmap.put(btnList.get(i),arr.get(i));
			countMap.put(i, arr.get(i).getStockQuantity());
		}
		
	}
//	@FXML
//	public Button item0,item1,item2,item4,item5,item6,item7,item8,item9,item10,item11,item12;
	
	@FXML
	public TextArea textArea, totalPrice;
	
	@FXML
	private void operands(ActionEvent event) {
		
		Item buttonGetId = btnmap.get(((Button)event.getSource()).getId());
		if(buttonGetId.getStockQuantity()<=0) {
			Stage stage2 = new Stage();
			StackPane pane = new StackPane();
			Scene scene2 = new Scene(pane, 500,130);
			Label alert = new Label("��� �����մϴ�");
			
			alert.setAlignment(Pos.CENTER);
			alert.setStyle("-fx-font-size:25;-fx-font-color:RED;");
			pane.getChildren().add(alert);
			stage2.setScene(scene2);
			return;
		} 
		
		textArea.setText(textArea.getText()+((Button) event.getSource()).getText()+"\n");
		
		//total price ����ϱ�
		x = buttonGetId.getPrice();
		result += x;
		countMap.put(buttonGetId.getId(), countMap.get(buttonGetId.getId())-1);
		totalPrice.setStyle("-fx-font-size:25;-fx-font-weight: bold;");
		totalPrice.setText("Total Price : " + result + " ��");		
	}

	@FXML
	private void operator(ActionEvent event) throws IOException {
		GridPane grid = new GridPane();
		StackPane pane = new StackPane();
		Scene scene1 = new Scene(pane, 500,130);
		Stage stage = new Stage();
		Label message = new Label();
		
		if(x==0) {
			((Button) event.getSource()).setDisable(true);
		} else {		            
	        if (((Button) event.getSource()).getText().equals("CASH")) {
	        	message.setText("������ �־��ּ���");
	        } 	else {
	        	message.setText("ī�带 �־��ּ���");
	        }
	        message.setStyle("-fx-font-size:25;-fx-font-weight: bold;");
	
			Button pay = new Button("����");
			Button ok = new Button("Ȯ��");
	
			grid.addRow(0, ok, pay);
			grid.setAlignment(Pos.BOTTOM_RIGHT);
			grid.setPadding(new Insets (0,10,10,0));
			grid.setHgap(20);
		
			pay.setOnMouseClicked(e->{
				//1.stockquantity ������ŭ ���δ�
				for(int i=0;i<arr.size();i++) {
					if(arr.get(i).getStockQuantity()!= countMap.get(i)) {
						item.minusStockQuantity(i+1,countMap.get(i));
					}
				}
				//2. order�� �����Ѵ�
				int getOrderId = orderService.save(1);
				
				//3. order item�� �����Ѵ�
				for(int i=0;i<arr.size();i++) {
					if(arr.get(i).getStockQuantity()!= countMap.get(i)) {
						orderItem.save(new OrderItem(getOrderId, arr.get(i).getId(), arr.get(i).getPrice(), arr.get(i).getStockQuantity()-countMap.get(i)));
					}
				}
				
				message.setStyle("-fx-font-size:25;-fx-font-weight: bold;");
				message.setText("������ �Ϸ�Ǿ����ϴ�. Ȯ��â�� �����ּ���");
			});

			ok.setOnMouseClicked(e->{
				stage.close();
				textArea.clear();
				totalPrice.clear();
				textArea.setText("\n \t\t\t\tOrder List\n");
				totalPrice.setText("\n \t\t\tTotal Price\n");
			});
		}
		pane.getChildren().addAll(grid, message);
		stage.setTitle("����â");
		stage.setScene(scene1);
		stage.show();
}
	
	@FXML
	private void refresh(ActionEvent event) {
		textArea.clear();
		textArea.setText("\n \t\t\t\tOrder List\n");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}

}
