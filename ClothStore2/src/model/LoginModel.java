package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.dao.LoginDao;

public class LoginModel implements LoginDao{

	String url = "jdbc:oracle:thin:@192.168.0.79:1521:orcl";
	String user = "ryu";
	String pass=  "1234";
	
	public String selectIdPw(String id) throws Exception {
		Connection con=null;
		String pw="";
		
		try {
			con = DriverManager.getConnection(url,user,pass);
			
			String sql = "SELECT STPASS FROM STAFF WHERE STID = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			pw=rs.getString("STPASS");
			
			
			ps.close();
			rs.close();
			
		}finally {
			con.close();
		}

		return pw;
	}
	

}
