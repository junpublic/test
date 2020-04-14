import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSelect {

	public static void main(String[] args) {
			try {
			
			//1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.Connection얻어오기
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.22:1521:orcl","scott","tiger");
			
			//3.SQL 문장
			String sql = "SELECT empno,ename,sal,job FROM emp";

			//4.전송객체 얻어오기
			Statement st = con.createStatement();
			
			//5.전송
			ResultSet rs = st.executeQuery(sql);
			
			//결과를 확인
			while(rs.next()) {//다음 레코드가 있으면 true 없으면 false
				System.out.print(rs.getInt("EMPNO"+"\t"));
				System.out.print(rs.getString("ENAME"+"\t"));
				System.out.print(rs.getInt("SAL"+"\t"));
				System.out.println(rs.getString("JOB"+"\t"));
				
			}
			
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
