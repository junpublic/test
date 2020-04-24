package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.dao.SalesDao;

public class SalesModel implements SalesDao {

	String url = "jdbc:oracle:thin:@192.168.0.79:1521:orcl";
	String user = "ryu";
	String pass=  "1234";
	
	
	public SalesModel() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");

	}
	public ArrayList selectBydate(String date) throws Exception {
		Connection con=null;
		ArrayList data = new ArrayList();

		try {
			con = DriverManager.getConnection(url,user,pass);
		
			
			String sql = " SELECT * FROM sales WHERE to_char(sdate,'MM-DD')=? ORDER BY SCODE ";
		
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, date);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				ArrayList temp = new ArrayList();
				temp.add(rs.getInt("SCODE"));
				temp.add(rs.getInt("SSQ"));
				temp.add(rs.getInt("STODAY"));
				temp.add(rs.getDate("SDATE"));
				temp.add(rs.getString("PCODE"));
				temp.add(rs.getString("STID"));
				temp.add(rs.getString("CTEL"));

				data.add(temp);
			}

			ps.close();
			rs.close();
			

		}finally {
			con.close();
		}
		return data;
		
	}
	
	public ArrayList selectstaffid(String date,String id) throws Exception {
		Connection con=null;
		ArrayList data = new ArrayList();

		try {
			con = DriverManager.getConnection(url,user,pass);
			
			

			String sql = " SELECT * FROM sales WHERE to_char(sdate,'MM-DD')= ? AND STID = ? ORDER BY SCODE ";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, date);
			ps.setString(2, id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				ArrayList temp = new ArrayList();
				temp.add(rs.getInt("SCODE"));
				temp.add(rs.getInt("SSQ"));
				temp.add(rs.getInt("STODAY"));
				temp.add(rs.getDate("SDATE"));
				temp.add(rs.getString("PCODE"));
				temp.add(rs.getString("STID"));
				temp.add(rs.getString("CTEL"));

				data.add(temp);
			}

			ps.close();
			rs.close();
			

		}finally {
			con.close();
		}
		return data;
	}
	@Override
	public ArrayList selectByMonth(String date) throws Exception {
		Connection con=null;
		ArrayList data = new ArrayList();

		try {
			con = DriverManager.getConnection(url,user,pass);
			
			
			String sql = " SELECT nvl(SUM(STODAY),0) SMONTH,COUNT(CTEL) TOTALC,  to_char(sdate,'YYYY-MM-DD') sdate" + 
					" FROM sales " + 
					" WHERE to_char(sdate,'YYYY-MM')=? " + 
					" group by to_char(sdate,'YYYY-MM-DD') " + 
					" ORDER BY sdate ";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, date);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				ArrayList temp = new ArrayList();
				temp.add(rs.getInt("TOTALC"));
				temp.add(rs.getDate("SDATE"));
				temp.add(rs.getInt("SMONTH"));
				temp.add(null);

				data.add(temp);
			}

			ps.close();
			rs.close();
			

		}finally {
			con.close();
		}
		return data;
		
	}
	@Override
	public ArrayList selectMstaffid(String date, String id) throws Exception {
		
		Connection con=null;
		ArrayList data = new ArrayList();

		try {
			con = DriverManager.getConnection(url,user,pass);
			
			

			String sql = " SELECT nvl(SUM(STODAY),0) SMONTH,COUNT(CTEL) TOTALC,  to_char(sdate,'YYYY-MM-DD') sdate,STID" + 
					" FROM sales" + 
					" WHERE to_char(sdate,'YYYY-MM')=? AND STID = ?" + 
					" group by to_char(sdate,'YYYY-MM-DD'),STID " +
					" ORDER BY sdate ";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, date);
			ps.setString(2, id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				ArrayList temp = new ArrayList();
				temp.add(rs.getInt("SMONTH"));
				temp.add(rs.getInt("TOTALC"));
				temp.add(rs.getDate("SDATE"));
				temp.add(rs.getString("STID"));
				

				data.add(temp);
			}

			ps.close();
			rs.close();
			

		}finally {
			con.close();
		}
		return data;
	}

	public ArrayList selectByYear() throws Exception {
		Connection con=null;
		ArrayList data = new ArrayList();

		try {
			con = DriverManager.getConnection(url,user,pass);
			
			
			String sql = " SELECT TO_CHAR(SDATE,'YYYY-MM') MONTH, SUM(STODAY) SMONTH,COUNT(CTEL) TOTALC" + 
					" FROM sales" + 
					" group by TO_CHAR(SDATE,'YYYY-MM')" + 
					" ORDER BY TO_CHAR(SDATE,'YYYY-MM')";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				ArrayList temp = new ArrayList();
				temp.add(rs.getInt("TOTALC"));
				temp.add(rs.getString("MONTH"));
				temp.add(rs.getInt("SMONTH"));
				temp.add(null);

				data.add(temp);
			}

			ps.close();
			rs.close();
			

		}finally {
			con.close();
		}
		return data;
	}
	@Override
	public ArrayList selectYstaffid(String id) throws Exception {
		
		Connection con=null;
		ArrayList data = new ArrayList();

		try {
			con = DriverManager.getConnection(url,user,pass);
			
			

			String sql = " SELECT TO_CHAR(SDATE,'MM') MONTH,SUM(STODAY) SMONTH,COUNT(CTEL) TOTALC,STID " + 
					" FROM sales " +
					" WHERE STID = ? "+
					" group by TO_CHAR(SDATE,'MM'),STID " + 
					" ORDER BY TO_CHAR(SDATE,'MM') ";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				ArrayList temp = new ArrayList();
				temp.add(rs.getInt("TOTALC"));
				temp.add(rs.getString("MONTH"));
				temp.add(rs.getInt("SMONTH"));
				temp.add(rs.getString("STID"));
				

				data.add(temp);
			}

			ps.close();
			rs.close();
			

		}finally {
			con.close();
		}
		return data;
	}
	@Override
	public ArrayList selectByProduct() throws Exception {
		Connection con=null;
		ArrayList data = new ArrayList();

		try {
			con = DriverManager.getConnection(url,user,pass);
			
			
			String sql = " SELECT  s.PCODE PCODE,COUNT(s.CTEL) TOTALC, SUM(s.STODAY) SMONTH, p.PNAME PNAME" + 
					" FROM sales s INNER JOIN PRODUCT p" + 
					" ON s.PCODE = p.PCODE" + 
					" group by s.PCODE,P.PNAME" + 
					" ORDER BY s.PCODE ";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				ArrayList temp = new ArrayList();
				temp.add(rs.getInt("TOTALC"));
				temp.add(rs.getInt("SMONTH"));
				temp.add(rs.getString("PNAME"));
				temp.add(rs.getString("PCODE"));

				
				data.add(temp);
			}

			ps.close();
			rs.close();
			

		}finally {
			con.close();
		}
		return data;
	}
	@Override
	public ArrayList selectProductId(String pid) throws Exception {
		
		Connection con=null;
		ArrayList data = new ArrayList();

		try {
			con = DriverManager.getConnection(url,user,pass);
			
			

			String sql = " SELECT  s.PCODE PCODE,COUNT(s.CTEL) TOTALC, TO_CHAR(s.SDATE,'MM') MONTH, SUM(s.STODAY) SMONTH, p.PNAME PNAME " + 
					" FROM sales s INNER JOIN PRODUCT p\r\n" + 
					" ON s.PCODE = p.PCODE " + 
					" WHERE s.PCODE = ? " + 
					" group by s.PCODE,TO_CHAR(s.SDATE,'MM'),P.PNAME " + 
					" ORDER BY s.PCODE ";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, pid);
			
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				ArrayList temp = new ArrayList();
				temp.add(rs.getInt("TOTALC"));
				temp.add(rs.getString("MONTH"));
				temp.add(rs.getInt("SMONTH"));
				temp.add(rs.getString("PNAME"));
				temp.add(rs.getString("PCODE"));
				

				data.add(temp);
			}

			ps.close();
			rs.close();
			

		}finally {
			con.close();
		}
		return data;
	}



}

