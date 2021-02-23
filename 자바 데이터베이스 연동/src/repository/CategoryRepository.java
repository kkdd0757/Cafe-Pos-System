package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Category;
import model.Member;

public class CategoryRepository {	
    
    public void join(Category category) {
    	Connection conn = null; 
        PreparedStatement pstmt = null; 
//        ResultSet rs = null; 
        
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", 
	                "root", "950307"); 
			
			String sql = "INSERT INTO CATEGORY(category_name) Values(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category.getName());
			
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
    
    
}


