package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.vo.Product;

public class SellModel {
	String url;
	String user;
	String pass;
	
	public SellModel() throws Exception{
		// 1. 드라이버로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");
				url = "jdbc:oracle:thin:@192.168.0.79:1521:orcl";
				user = "ryu";
				pass = "1234";
	}
	//이름과 가격 가져옴
	public Product searchProduct(String pCode) throws Exception {
		Connection con = null;
		Product data = new Product();
		try {
			// 2. Connection 연결객체 얻어오기
			con = DriverManager.getConnection(url, user, pass);
			// 3. sql 문장 만들기(INSERT 문장 만들기)
			String sql = " SELECT PNAME name,PPRICE price " + 
					" FROM PRODUCT " + 
					" WHERE PCODE = ? ";
			// 4. sql 전송객체 (PreparedStatement)
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, pCode);

			// 5. sql 전송
			ResultSet rs = st.executeQuery();

			while (rs.next()) {// 인덱스오류
				
				data.setPname(rs.getString("name"));
				data.setPprice(Integer.parseInt(rs.getString("price")));
				
			}

			// 6. 닫기
			st.close();
			rs.close();
		} finally {
			con.close();
		}
		return data;

	}
	
	public void insertSell() throws Exception{
		
	}
	
	public ArrayList selectList(String Code) throws Exception {
		ArrayList data = new ArrayList();
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, pass);

			String sql = " SELECT PCODE PCODE,PNAME PNAME,PPRICE PPRICE," + " PKIND PKIND,PSIZE PSIZE, PSTOCK PSTOCK "
					+ " FROM PRODUCT " + " WHERE PCODE = ? ";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, Code);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				ArrayList a = new ArrayList();
				
				a.add(null);				
				a.add(rs.getString("PCODE"));
				a.add(rs.getString("PNAME"));
				a.add(rs.getInt("PPRICE"));
				a.add(rs.getString("PKIND"));
				a.add(rs.getString("PSIZE"));
				a.add(rs.getInt("PSTOCK"));
				data.add(a);
			}

			st.close();
			rs.close();
		} finally {
			con.close();
		}
		return data;
	}

}
