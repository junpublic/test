import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect3 {

	public static void main(String[] args) {
		// hr 계정에서 사원번호, 사원 전체이름 ,부서명을 출력하되
		// 급여가 3000이상인 사원 목록을 출력하세오.
		Connection con = null;//지역변수는 초기화 해줘야 한다.
		try {

			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.Connection얻어오기
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.22:1521:orcl", "hr", "hr");

			// 3.SQL 문장
			String sql = " SELECT e.EMPLOYEE_ID id, e.FIRST_NAME||' '||e.LAST_NAME name,d.DEPARTMENT_NAME buse\r\n " + 
					" FROM EMPLOYEES e INNER JOIN DEPARTMENTS d\r\n " + 
					" ON e.DEPARTMENT_ID = d.department_id\r\n "+ 
					" WHERE SALARY>=3000 ";

			// 4.전송객체 얻어오기
			Statement st = con.createStatement();

			// 5.전송
			ResultSet rs = st.executeQuery(sql);

			
			// 결과를 확인
			
			//hr 계정에서 사원번호, 사원 전체이름 ,부서명을 출력하되 
			//급여가 3000이상인 사원 목록을 출력하세오.
			while(rs.next()) {
				System.out.print(rs.getInt("id")+"\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getString("buse")+"\t");
				System.out.println();
			}
			

			// 6.닫기
			rs.close();
			st.close();
			System.out.println("성공");
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			System.out.println("실패:" + ex.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}

}

