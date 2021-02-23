package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
    public static void main(String arg[]) throws Exception { 
		Connection conn; 
	      Statement stmt; 
	      ResultSet rs; 
	
	      Class.forName("com.mysql.jdbc.Driver");  // JDBC driver를 메모리에 로드
	      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", 
	                "root", "950307"); 
	      stmt = (Statement) conn.createStatement(); 
		              rs=stmt.executeQuery("SELECT * FROM orderItem");  // 원하는 쿼리문 실행

//	      stmt.executeUpdate("INSERT INTO orderitem(orderId, itemId, orderPrice,count) Values('3','3','4500','2')");
//	      stmt.executeUpdate("INSERT INTO orderitem(orderId, itemId, orderPrice,count) Values('4','1','4000','1')");
//	      stmt.executeUpdate("INSERT INTO orderitem(orderId, itemId, orderPrice,count) Values('4','4','5000','3')");
//	
	//	              while(rs.next()) { 
	//	                        System.out.print(rs.getString("itemId") + " ");  
	//	                        System.out.println(rs.getString("count")); 
	//	              } 
	
	      rs.close(); 
	      stmt.close(); 		
	      conn.close();
    }	 
	    
}
