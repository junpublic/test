import java.sql.*;
public class TestInsert {

	public static void main(String[] args) {
		
		try {
			
			//1.드라이버 로딩
			//new oracle.jdbc.driver.OracleDriver();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.Connection얻어오기
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.22:1521:orcl","scott","tiger");
			
			//3.SQL 문장
			String sql = "INSERT INTO emp(empno,ename,sal) VALUES(9001,'맹순이',4000)";
			
			//4.전송객체 얻어오기
			Statement st = con.createStatement();
			
			//5.전송
			st.executeUpdate(sql);
			
			//6.닫기
			st.close();
			con.close();
			System.out.println("성공");
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			System.out.println("실패:"+ex.getMessage());
		}
		
		

	}

}
