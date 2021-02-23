package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Member;
import model.Orders;

public class OrdersRepository {
	
	    public int createOrder(int memberId) {//새로운값 넣어줌
	    	Connection conn = null; 
	        PreparedStatement pstmt = null; 
	        ResultSet rs = null;
	        int id = 0;
	        
	    	try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", 
		                "root", "950307"); 
				
				String sql = "INSERT INTO ORDERS(memberId) Values(?)";
				pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				pstmt.setInt(1, memberId);
				
				pstmt.executeUpdate();

				rs = pstmt.getGeneratedKeys(); 
				rs.next();
				id = rs.getInt(1);
				System.out.println(id);

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
	    	return id;
	    }
	    public ArrayList<Orders> getList() {//전체 order 보여줌
	    	Connection conn = null; 
	        PreparedStatement pstmt = null; 
	        ResultSet rs = null; 
	        ArrayList<Orders> list = new ArrayList<Orders>();
	    	try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", 
		                "root", "950307"); 
				String sql = "SELECT * FROM ORDERS";
				
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {//행얻기
	                //열데이터 얻기
	                Orders order = new Orders();
	                order.setId(rs.getInt("id"));
	                order.setMemberId(rs.getInt("memberId"));
	                order.setOrderDate(rs.getTimestamp("orderDate"));            
	                list.add(order);
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
	      public Orders getOrders(int id) {//특정 order만 보여주기
	    	Connection conn = null; 
	        PreparedStatement pstmt = null; 
	        ResultSet rs = null; 
	        Orders order = new Orders();
	    	try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", 
		                "root", "950307"); 
				String sql = "SELECT * FROM ORDERS WHERE id=?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {//행얻기
	                //열데이터 얻기
	                order.setId(rs.getInt("id"));
	                order.setMemberId(rs.getInt("id"));
	                order.setOrderDate(rs.getTimestamp("orderDate"));            
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
	    	return order;
	      
	    }
}
