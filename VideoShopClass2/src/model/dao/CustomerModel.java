package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.CustomerDao;
import model.vo.Customer;

public class CustomerModel implements CustomerDao{
	String url = "jdbc:oracle:thin:@192.168.0.79:1521:orcl";
	String user = "ryu";
	String pass = "1234";
	
	
	public CustomerModel() throws Exception{
	 	// 1. 드라이버로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
	}
	
	public void insertCustomer(Customer vo) throws Exception{
		Connection con = null;
		// 2. Connection 연결객체 얻어오기
		try{
			con = DriverManager.getConnection(url, user, pass);
		// 3. sql 문장 만들기(INSERT INTO 문장 만들기) 회원번호있으면 sequence.nextby만 때린다.
		String sql = " INSERT INTO member(phone, name, subphone, address, email ) VALUES(?, ?, ?, ?, ?)";
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
		}finally{con.close();
		}
	}
	
	public Customer selectByTel(String tel) throws Exception{
		Customer dao = new Customer();
		Connection con = null;
		try {
		con = DriverManager.getConnection(url, user, pass);
		String sql = " SELECT * FROM member WHERE phone = ? ";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, tel);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			dao.setCustTel1(rs.getString("PHONE"));
			dao.setCustName(rs.getString("NAME"));
			dao.setCustTel2(rs.getString("SUBPHONE"));
			dao.setCustAddr(rs.getString("ADDRESS"));
			dao.setCustEmail(rs.getString("EMAIL"));
		}
		st.close();
		rs.close();
	}finally{con.close();}
		return dao;
		
	}
	
	public int updateCustomer(Customer vo) throws Exception{
		
		Connection con = null;
		int result = 0;
		try {
		con = DriverManager.getConnection(url, user, pass);
		
		String sql = " UPDATE member "
				+ " SET name = ?, subphone = ?, address = ?, email = ? "
				+ " WHERE phone = ? ";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, vo.getCustName());
		st.setString(2, vo.getCustTel2());
		st.setString(3, vo.getCustAddr());
		st.setString(4, vo.getCustEmail());
		st.setString(5, vo.getCustTel1());
		result = st.executeUpdate();
		
		st.close();
		}finally{
		con.close();}
		return result;
	}
}
