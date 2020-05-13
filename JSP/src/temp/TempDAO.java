package temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TempDAO {
	static TempDAO dao;
	public static TempDAO getInstance() throws Exception {//싱글톤패턴: static으로 만들어서 많은 사람들이 이거 하나만 써도 되게만듦
		if(dao == null) {//맨 처음에 접속하는 사람은 null이니까 객체가 생성됨
			dao = new TempDAO();
		}
	return dao;//객채생성된것을 리턴
	}
	
	private TempDAO() throws Exception{//생성자를 private로 선언하여 다른 클래스에서 해당 클래스의 인스턴스를 new로 생성하지 못하게 하고, getInstance()함수를 통해서 인스턴스를 갖도록 한다.
		//드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
		
	}
	public void insert(TempVO vo) {
		Connection con = null;
		
		//연결객체 얻어오기
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.49:1521:orcl","scott","tiger");
			//3.sql문장 (insert문)
			String sql = "INSERT INTO temp VALUES(?,?,?,?,?) ";
			
			//4. 전송객체 얻어오기 (PreparedStatement)+? 지정
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getTel());
			ps.setString(5, vo.getAddr());
			//5.전송(executeUpdate()이용)
			ps.executeUpdate();
			//6.닫기
			ps.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
	}
	/*
	 * 메소드명 :login
	 * 매개변수 :TempVO
	 * 리턴형:boolean
	 * 역할: 아이디와 패스워드를 받아서 해당 테이블에 존재하는지 확인 후 boolean 리턴한다.
	 */
	public boolean login(TempVO vo )throws Exception {
		boolean success = false;
		Connection con = null;
		
		//연결객체 얻어오기
				try {
					con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.49:1521:orcl","scott","tiger");
					//3.sql문장 (insert문)
					String sql = " SELECT *  " + 
							" from temp " + 
							" where id=? and pass=? ";
					
					//4. 전송객체 얻어오기 (PreparedStatement)+? 지정
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, vo.getId());
					ps.setString(2, vo.getPass());
				
					//5.전송(executeUpdate()이용)
					ResultSet rs = ps.executeQuery();
					//6.닫기
					if(rs.next()) {
						success = true;
					}
					
					ps.close();
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				
			return success;//boolean 리턴
	}
	
//	public TempVO login(TempVO vo )throws Exception {
//		boolean success = false;
//		Connection con = null;
//		
//		//연결객체 얻어오기
//				try {
//					con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.49:1521:orcl","scott","tiger");
//					//3.sql문장 (insert문)
//					String sql = " SELECT *  " + 
//							" from temp " + 
//							" where id=? and pass=? ";
//					
//					//4. 전송객체 얻어오기 (PreparedStatement)+? 지정
//					PreparedStatement ps = con.prepareStatement(sql);
//					ps.setString(1, vo.getId());
//					ps.setString(2, vo.getPass());
//				
//					//5.전송(executeUpdate()이용)
//					ResultSet rs = ps.executeQuery();
//					//6.닫기
//					if(rs.next()) {
//						success = true;
//					}
//					
//					ps.close();
//					con.close();
//				} catch (SQLException e) {
//					System.out.println(e.getMessage());
//					e.printStackTrace();
//				}
//				
//			return vo;//boolean 리턴
//	}
}
