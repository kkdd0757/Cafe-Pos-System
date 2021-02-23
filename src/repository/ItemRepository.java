package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Item;
import model.Member;

public class ItemRepository {
    public void join(Item item) {
    	Connection conn = null; 
        PreparedStatement pstmt = null; 
        ResultSet rs = null; 
        
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", 
	                "root", "950307"); 
			
			String sql = "INSERT INTO ITEM(name, price, stockQuantity, category_id) Values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item.getName());
			pstmt.setInt(2, item.getPrice());
			pstmt.setInt(3, item.getStockQuantity());
			pstmt.setInt(4, item.getCategoryId());
			
			pstmt.executeUpdate();
			
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
    }
    public ArrayList<Item> getList() {
    	Connection conn = null; 
        PreparedStatement pstmt = null; 
        ResultSet rs = null; 
        ArrayList<Item> list = new ArrayList<Item>();
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", 
	                "root", "950307"); 
			String sql = "SELECT * FROM ITEM";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {//행얻기
                //열데이터 얻기
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));  
                item.setPrice(rs.getInt("price"));
                item.setStockQuantity(rs.getInt("stockQuantity"));
                list.add(item);
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
    public Item getItem(int id) {
    	Connection conn = null; 
        PreparedStatement pstmt = null; 
        ResultSet rs = null; 
        Item item = new Item();
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", 
	                "root", "950307"); 
			String sql = "SELECT * FROM ITEM WHERE id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {//행얻기
                //열데이터 얻기
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));            
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
    	return item;
    }        
    public void minusStockQuantity(int id, int stockQuantity) {
    	Connection conn = null; 
        PreparedStatement pstmt = null;
        
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", 
	                "root", "950307"); 
			String sql = "UPDATE item SET stockQuantity = ? WHERE id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stockQuantity);
			pstmt.setInt(2, id);
			
			pstmt.executeUpdate();
			
	} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			try {
				
				pstmt.close(); 		
			    conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		    
		}
    }   
}

