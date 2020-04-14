import java.sql.*;
public class TestUpdate {

	public static void main(String[] args) {
		
		try {
			
			//1.드라이버 로딩
			//new oracle.jdbc.driver.OracleDriver();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.Connection얻어오기
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.22:1521:orcl","scott","tiger");
			
			//3.SQL 문장
			//9001번 사원의 이름은 '홍길숙'이고 급여는 4500원으로 변경
			//String sql = "UPDATE emp SET  , sal = 4500 WHERE empno = 9001";
			//20번 부서의 사원들 급여를 500 인상
			String sql = "UPDATE emp SET   sal = sal +500 WHERE deptno = 20";

			//4.전송객체 얻어오기
			Statement st = con.createStatement();
			
			//5.전송
			//	-int executeUpdate() : INSERT/UPDATE/DELETE
			//	-ResultSet executeQuery(): SELECT
			st.executeUpdate(sql);
			int result = st.executeUpdate(sql);
			System.out.println(result + "행을 실행합니다.");
			
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
