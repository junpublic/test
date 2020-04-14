import java.sql.*;
public class TestUpdate2 {

	public static void main(String[] args) {
		
		int deptno = 20;
		int salInc = 500;
		
		Connection  con = null;
		
		try {
			
			//1.드라이버 로딩
			//new oracle.jdbc.driver.OracleDriver();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.Connection얻어오기
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.22:1521:orcl","scott","tiger");
			
			//3.SQL 문장
			
			String sql = "UPDATE emp SET   sal = sal +? WHERE deptno = ?";
			System.out.println(sql);

			//4.전송객체 얻어오기
			//Statement st = con.createStatement();
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,salInc);
			st.setInt(2,deptno);
			//5.전송
			
			st.executeUpdate();
			//int result = st.executeUpdate();
			
			//6.닫기
			//st.close();
			con.close();
			System.out.println("성공");
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			System.out.println("실패:"+ex.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
		
		

	}

}
