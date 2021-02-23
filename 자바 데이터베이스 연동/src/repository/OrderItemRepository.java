package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.OrderItem;
import model.Orders;

public class OrderItemRepository {
    public void createOrderItem(OrderItem orderItem) {//새로운값 넣어줌
    	Connection conn = null; 
        PreparedStatement pstmt = null; 
//        ResultSet rs = null; 
        
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", 
	                "root", "950307"); 
			
			String sql = "INSERT INTO ORDERITEM(orderId, itemId, orderPrice, count) Values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderItem.getOrderId());
			pstmt.setInt(2, orderItem.getItemId());
			pstmt.setLong(3, orderItem.getOrderPrice());
			pstmt.setInt(4, orderItem.getCount());
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			try {
//				rs.close();
				pstmt.close(); 		
			    conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		    
		}
      
    }
    public ArrayList<OrderItem> getList() {//전체 order 보여줌
    	Connection conn = null; 
        PreparedStatement pstmt = null; 
        ResultSet rs = null; 
        ArrayList<OrderItem> list = new ArrayList<OrderItem>();
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", 
	                "root", "950307"); 
			String sql = "SELECT * FROM ORDERITEM";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {//행얻기
                //열데이터 얻기
                OrderItem orderItem = new OrderItem();
                orderItem.setId(rs.getInt("id"));
                orderItem.setOrderId(rs.getInt("orderId"));
                orderItem.setItemId(rs.getInt("itemId"));
                orderItem.setOrderPrice(rs.getInt("orderPrice"));
                orderItem.setCount(rs.getInt("count"));
                list.add(orderItem);
            }
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			try {
				rs.close();
				pstmt.close(); 		
			    conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		    
		}
    	return list;
      
    }
      public OrderItem getOrderItem(int id) {//특정 order만 보여주기
    	Connection conn = null; 
        PreparedStatement pstmt = null; 
        ResultSet rs = null; 
        OrderItem orderItem = new OrderItem();
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", 
	                "root", "950307"); 
			String sql = "SELECT * FROM ORDERITEM WHERE id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {//행얻기
                //열데이터 얻기
				orderItem.setId(rs.getInt("id"));
                orderItem.setOrderId(rs.getInt("orderId"));
                orderItem.setItemId(rs.getInt("itemId"));
                orderItem.setOrderPrice(rs.getInt("orderPrice"));
                orderItem.setCount(rs.getInt("count"));         
            }
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			try {
				rs.close();
				pstmt.close(); 		
			    conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		    
		}
    	return orderItem;
      
    }

}
