package view.graph;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Database {

	String URL = "jdbc:oracle:thin:@192.168.0.79:1521:orcl";
	String USER ="ryu";
	String PASS = "1234";

	public ArrayList<ArrayList> getData(String date) {

		ArrayList<ArrayList> data = new ArrayList<ArrayList>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(URL, USER , PASS);	

			//***************************************************************
			String sql=" SELECT sum(s.STODAY) STODAY ,p.pname pname " + 
					" FROM sales s INNER JOIN product p " + 
					" ON s.pcode=  p.pcode " + 
					" WHERE to_char(s.SDATE,'MM-DD') = ?"+
					" group by s.PCODE, p.pname";
			//***************************************************************

			PreparedStatement stmt = con.prepareStatement( sql );	
			stmt.setString(1, date);
			ResultSet rset = stmt.executeQuery();


			while( rset.next() ){
				ArrayList temp = new ArrayList();
				temp.add( rset.getInt("STODAY"));				//****************
				temp.add( rset.getString("PNAME"));		//****************		
				data.add(temp);
			}
			rset.close();
			stmt.close();
			con.close();
		} catch(Exception ex){
			System.out.println("에러 : " + ex.getMessage() );
		}
		return data;
	}
	public ArrayList<ArrayList> getDataMonth(String date) {

		ArrayList<ArrayList> data = new ArrayList<ArrayList>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(URL, USER , PASS);	

			//***************************************************************
			String sql=" SELECT nvl(SUM(STODAY),0) SMONTH, to_char(sdate,'YYYY-MM-DD') MONTH" + 
					" FROM sales" + 
					" WHERE to_char(sdate,'YYYY-MM')=?" + 
					" group by to_char(sdate,'YYYY-MM-DD')"+
					" order by to_char(sdate,'YYYY-MM-DD')";

			//***************************************************************

			PreparedStatement stmt = con.prepareStatement( sql );	
			stmt.setString(1, date);
			ResultSet rset = stmt.executeQuery();


			while( rset.next() ){
				ArrayList temp = new ArrayList();
				temp.add( rset.getInt("SMONTH"));				//****************
				temp.add( rset.getString("MONTH"));		//****************		
				data.add(temp);
			}
			rset.close();
			stmt.close();
			con.close();
		} catch(Exception ex){
			System.out.println("에러 : " + ex.getMessage() );
		}
		return data;
	}
	public ArrayList<ArrayList> getDataYear() {

		ArrayList<ArrayList> data = new ArrayList<ArrayList>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(URL, USER , PASS);	

			//***************************************************************
			String sql=" SELECT TO_CHAR(SDATE,'MM') MONTH, SUM(STODAY) SMONTH" + 
					" FROM sales " + 
					" group by TO_CHAR(SDATE,'MM')" + 
					" ORDER BY TO_CHAR(SDATE,'MM')";

			//***************************************************************

			PreparedStatement stmt = con.prepareStatement( sql );	
			//stmt.setString(1, date);
			ResultSet rset = stmt.executeQuery();


			while( rset.next() ){
				ArrayList temp = new ArrayList();
				temp.add( rset.getInt("SMONTH"));				//****************
				temp.add( rset.getString("MONTH"));		//****************		
				data.add(temp);
			}
			rset.close();
			stmt.close();
			con.close();
		} catch(Exception ex){
			System.out.println("에러 : " + ex.getMessage() );
		}
		return data;
	}
	public ArrayList<ArrayList> getDataProduct() {
		
		ArrayList<ArrayList> data = new ArrayList<ArrayList>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(URL, USER , PASS);	
			
			//***************************************************************
			String sql="SELECT SUM(s.STODAY) SALES, p.PNAME PNAME " + 
					" FROM sales s INNER JOIN PRODUCT p " + 
					" ON s.PCODE = p.PCODE " + 
					" group by s.PCODE,P.PNAME " + 
					" ORDER BY s.PCODE ";
			
			//***************************************************************
			
			PreparedStatement stmt = con.prepareStatement( sql );	
			//stmt.setString(1, date);
			ResultSet rset = stmt.executeQuery();
			
			
			while( rset.next() ){
				ArrayList temp = new ArrayList();
				temp.add( rset.getInt("SALES"));				//****************
				temp.add( rset.getString("PNAME"));		//****************		
				data.add(temp);
			}
			rset.close();
			stmt.close();
			con.close();
		} catch(Exception ex){
			System.out.println("에러 : " + ex.getMessage() );
		}
		return data;
	}
}
