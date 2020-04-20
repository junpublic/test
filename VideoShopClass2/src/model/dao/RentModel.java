package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import model.RentDao;


public class RentModel implements RentDao{//패키지가 달라서 임포트 해줘야함
	String url = "jdbc:oracle:thin:@192.168.0.79:1521:orcl";
	String user = "ryu";
	String pass = "1234";
	
	Connection con;
	
	public RentModel() throws Exception{
		// 1. 드라이버로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");		
	}

	@Override
	public String selectByTel(String tel) throws Exception {
		con = DriverManager.getConnection(url, user, pass);
		String c_name = "";
		try {
			
		String sql = "SELECT * FROM MEMBER WHERE PHONE = ? ";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, tel);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			c_name = rs.getString("NAME");
		}
		st.close();
		rs.close();
		}finally{
			con.close();
		}
		return c_name;
	}

	@Override
	public void rentVideo(String tel, int vnum) throws Exception {
		con = DriverManager.getConnection(url, user, pass); 
		String sql = "INSERT INTO RENT(RENT_ID, PHONE, NUM, RENT_DATE) "
				+ " VALUES(seq_RENT_RENT_ID.NEXTVAL, ?, ?, sysdate) ";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, tel);
		st.setInt(2, vnum);
	
		st.executeUpdate();
		
		st.close();
		con.close();

	}
	/**
	 * 	함수명 : rentVideo
	 * 	인자 : 전화번호(String), 비디오번호(int) 
	 * 	리턴값 : void 
	 * 	역할 : 대여테이블에 정보를 입력
	 */
	@Override
	public int returnVideo(int vnum) throws Exception {
		con = DriverManager.getConnection(url, user, pass);
		int result = 0;
		String sql = " UPDATE RENT SET RETURN_VIDEO = sysdate WHERE NUM = ? AND RETURN_VIDEO IS NULL";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, vnum);
		result = st.executeUpdate();
		
		st.close();
		con.close();
		return result;
		
		
		
		/**
		 * 	함수명 : returnVideo
		 * 	인자 : 비디오번호(int) 
		 * 	리턴값 : int 
		 * 	역할 : 대여테이블에 반납일 기입
		 */
	}

	@Override
	public ArrayList selectList() throws Exception {
		con = DriverManager.getConnection(url, user, pass);
		ArrayList data = new ArrayList();
		String sql = "select r.num num, v.title title, m.name name,  r.phone phone, TO_CHAR(r.rent_date+3, 'YYYY-MM-DD') return_dyedate, '미납' return_status " + 
				"FROM rent r, video v, member m " + 
				" where r.num = v.num AND m.phone = r.phone AND r.return_video IS NULL ";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("num"));
			temp.add(rs.getString("title"));
			temp.add(rs.getString("name"));
			temp.add(rs.getString("phone"));
			temp.add(rs.getString("return_dyedate"));
			temp.add(rs.getString("return_status"));
			data.add(temp);
		}
		
		return data;
	}
	
	
}
