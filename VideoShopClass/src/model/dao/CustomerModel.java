package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.CustomerDao;
import model.vo.Customer;

public class CustomerModel implements CustomerDao{

	String url;
	String user;
	String pass;
	
	public CustomerModel() throws Exception{
	 	// 1. 드라이버로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		url = "jdbc:oracle:thin:@192.168.0.79:1521:orcl";
		user = "ryu";
		pass = "1234";
		
	}
	
	public void insertCustomer(Customer vo) throws Exception{
		Connection con = null;
		try {
		// 2. Connection 연결객체 얻어오기
		con = DriverManager.getConnection(url,user,pass);
		// 3. sql 문장 만들기(INSERT 문장 만들기)
		String sql = " INSERT INTO MEMBER VALUES(?,?,?,?,?) ";
		// 4. sql 전송객체 (PreparedStatement)		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, vo.getCustTel1());
		st.setString(2, vo.getCustName());
		st.setString(3, vo.getCustTel2());
		st.setString(4, vo.getCustAddr());
		st.setString(5, vo.getCustEmail());
		
		// 5. sql 전송
		st.executeUpdate();
		
		// 6. 닫기 
		st.close();
		}finally {
			con.close();			
		}

	}
	
	public Customer selectByTel(String tel) throws Exception {
		Connection con = null;
		Customer dao = new Customer();
		try {
			// 2. Connection 연결객체 얻어오기
			con = DriverManager.getConnection(url, user, pass);
			// 3. sql 문장 만들기(INSERT 문장 만들기)
			String sql = " SELECT * FROM MEMBER WHERE PHONE = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, tel);
			// 4. sql 전송객체 (PreparedStatement)
			
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
			dao.setCustTel1(rs.getString("PHONE"));
			dao.setCustName(rs.getString("NAME"));
			dao.setCustTel2(rs.getString("SUBPHONE"));
			dao.setCustAddr(rs.getString("ADDRESS"));
			dao.setCustEmail(rs.getString("EMAIL"));
			}
			// 5. sql 전송
			

			st.close();
			rs.close();
		} finally {
			con.close();
		}

		return dao;

	}
	
	public int updateCustomer(Customer vo) throws Exception{
		
		int result = 0;
		
		
		return result;
	}
}
