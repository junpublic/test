package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import model.RentDao;
import model.vo.Video;


public class RentModel implements RentDao{
	String url;
	String user;
	String pass;
	
	Connection con;
	
	public RentModel() throws Exception{
		// 1. 드라이버로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");
				url = "jdbc:oracle:thin:@192.168.0.79:1521:orcl";
				user = "ryu";
				pass = "1234";
				
	}

	@Override
	public String selectByTel(String tel) throws Exception {
		
		Connection con = null;
		String name;
		try {
		con = DriverManager.getConnection(url,user,pass);
		
		String sql = " SELECT NAME FROM MEMBER  WHERE PHONE =?";
		
		//해당 비디오번호의 비디오정보를 검색하여 Video 클래스에 각각 멤버변수로 지정
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, tel);
		ResultSet rs = st.executeQuery();
		
		rs.next();//한줄을 이렇게만 해도 된다.
		name = rs.getString("NAME");
		
		st.close();
		rs.close();
		}finally {
			con.close();
		}
		
		
		return name;
	}
	/**
	 *  함수명:rentVideo
	 *  인자: 전화번호(String),비디오번호(int)
	 *  리턴값: void(없음)
	 *  역할: 대여테이블에 정보를 입력
	 */
	@Override
	public void rentVdieo(String tel, int vnum) throws Exception {

		Connection con = null;
		
		try {
		con = DriverManager.getConnection(url,user,pass);
			
		
//		String sql = "INSERT INTO 대여테이블(대여번호,전화번호,비디오번호,대여날짜) "
//				+ " VALUES(대여시퀀스.NEXTVAL,?,?,sysdate) ";
		
		String sql = " INSERT INTO RENT(RENT_ID,PHONE,NUM,RENT_DATE) "
				+ " VALUES(SEQ_RENT_RENT_ID.NEXTVAL,?,?,sysdate) ";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, tel);
		st.setInt(2, vnum);
		
		st.executeUpdate();
		
//		rs.next();//한줄을 이렇게만 해도 된다.
		
		
		
		st.close();
//		rs.close();
		}finally {
			con.close();
		}
	}

	@Override
	public int retrunVdieo(int vnum) throws Exception {
Connection con = null;
		
		try {
		con = DriverManager.getConnection(url,user,pass);
			
		
//		String sql = "INSERT INTO 대여테이블(대여번호,전화번호,비디오번호,대여날짜) "
//				+ " VALUES(대여시퀀스.NEXTVAL,?,?,sysdate) ";
		
		String sql = "";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, tel);
		st.setInt(2, vnum);
		
		st.executeUpdate();
		
//		rs.next();//한줄을 이렇게만 해도 된다.
		
		
		
		st.close();
//		rs.close();
		}finally {
			con.close();
		}
	}

	@Override
	public ArrayList selectList() throws Exception {
		Connection con = null;
		ArrayList data = new ArrayList();
		try {
		con = DriverManager.getConnection(url,user,pass);
		
		String sql = " SELECT r.num id,v.TITLE title,c.NAME name, r.PHONE PHONE,r.RENT_DATE+3 return_date,'미납' return_state " + 
				" FROM RENT r, VIDEO v ,MEMBER c " + 
				" WHERE r.NUM = v.NUM and r.PHONE = c.PHONE and r.RETURN_VIDEO IS NULL ";
		
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		 
		 while(rs.next()) {//인덱스오류
				ArrayList a = new ArrayList();
				a.add(rs.getString("id"));
				a.add(rs.getString("title"));
				a.add(rs.getString("name"));
				a.add(rs.getString("PHONE"));
				a.add(rs.getString("return_date"));
				a.add(rs.getString("return_state"));
				data.add(a);
			}
		
		st.close();
		rs.close();
		}finally {
			con.close();
		}
		return data;
	}
	
	
}
