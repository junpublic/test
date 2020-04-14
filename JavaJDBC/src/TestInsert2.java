import java.sql.*;
public class TestInsert2 {

	public static void main(String[] args) {
		
		Connection con = null;
		
		//화면에서 입력값을 받아서 저장한 변수라고 상상하기
		int empno = 9003;
		String ename = "김순이";
		int sal = 5000;
		
		try {
			
			//1.드라이버 로딩
			//new oracle.jdbc.driver.OracleDriver();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.Connection얻어오기
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.22:1521:orcl","scott","tiger");
			
			//3.SQL 문장
			String sql = "INSERT INTO emp(empno,ename,sal) "
						+ "   VALUES(?,?,?)";
						//+ "   VALUES("+empno+",'"+ename+"',"+sal+")";//너무 귀찮음
			System.out.println(sql);
			
			//4.전송객체 얻어오기
			//Statement st = con.createStatement();//이거는 sql을 안끌고 들어감
			PreparedStatement st = con.prepareStatement(sql);//이건 sql을 끌고 들어가야함
			st.setInt(1, empno);//values(?,?,?) 안에 값을 넣어줌
			st.setString(2, ename);
			st.setInt(3, sal);
			
			//5.전송
			//st.executeUpdate(sql);
			st.executeUpdate();//위에 먼저 끌고 갔으니 sql을 끌고가면 안됨
			
			//6.닫기
			st.close();
			
			System.out.println("성공");
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			System.out.println("실패:"+ex.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {//어짜피 못잡으니까 다 지웠음
			}
		}
		
		

	}

}
