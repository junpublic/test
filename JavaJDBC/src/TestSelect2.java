import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSelect2 {

	public static void main(String[] args) {
			try {
			
			//1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.Connection얻어오기
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.22:1521:orcl","scott","tiger");
			
			//3.SQL 문장
			String sql = "SELECT count(*) cnt FROM emp";

			//4.전송객체 얻어오기
			Statement st = con.createStatement();
			
			//5.전송
			ResultSet rs = st.executeQuery(sql);
			
			//결과를 확인
			rs.next();//next를 안해주면 맨 위 아무것도 없는 곳을 가리켜서 실행이 안됨 이걸 해주면 다음줄로 넘어감
			int result = rs.getInt("CNT");
			System.out.println(result + "명");
			
			//6.닫기
			rs.close();
			st.close();
			System.out.println("성공");
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			System.out.println("실패:"+ex.getMessage());
		}
	}
}
