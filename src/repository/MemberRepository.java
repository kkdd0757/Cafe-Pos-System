package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Member;


public class MemberRepository {
	
    
    public void join(Member member) {
    	Connection conn = null; 
        PreparedStatement pstmt = null; 
//        ResultSet rs = null; 
        
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", 
	                "root", "950307"); 
			
			String sql = "INSERT INTO MEMBER(name) Values(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			
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
    public ArrayList<Member> getList() {
    	Connection conn = null; 
        PreparedStatement pstmt = null; 
        ResultSet rs = null; 
        ArrayList<Member> list = new ArrayList<Member>();
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", 
	                "root", "950307"); 
			String sql = "SELECT * FROM MEMBER";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {//행얻기
                //열데이터 얻기
                Member member = new Member();
                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));            
                list.add(member);
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
      public Member getMember(int id) {
    	Connection conn = null; 
        PreparedStatement pstmt = null; 
        ResultSet rs = null; 
        Member member = new Member();
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", 
	                "root", "950307"); 
			String sql = "SELECT * FROM MEMBER WHERE id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {//행얻기
                //열데이터 얻기
                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));            
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
    	return member;
      
    }
    
}
