package jdbc.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InfoMoedlImpl implements InfoModel {
	String url = "jdbc:oracle:thin:@192.168.0.22:1521:orcl";//수정하기 편하게 전역변수로 지정
	String user = "scott";
	String pass = "tiger";

	public InfoMoedlImpl() throws Exception{//예외가 발생하면 넘겨버림
		//1.드라이버로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}
	@Override
	public void insert(InfoVO vo) throws SQLException {
		Connection con=null;
		try {
		//2.연결객체 얻어오기
		con = DriverManager.getConnection(url,user,pass);
		//3.sql문장
		String sql = "INSERT INTO info_tab(name,jumin,tel,gender,age,home) "
				+ " VALUES(?,?,?,?,?,?) ";
				
		//4.전송객체 얻어오기
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, vo.getName());
		st.setString(2, vo.getJumin());
		st.setString(3, vo.getTel());
		st.setString(4, vo.getGender());
		st.setInt(5, vo.getAge());
		st.setString(6, vo.getHome());
		
		//5.전송
		st.executeUpdate();
		//6.닫기
		st.close();
	}finally {
		con.close();
	}
		

	}
	public void modify(InfoVO vo)throws SQLException{
		Connection con=null;
		try {
		//2.연결객체 얻어오기
		con = DriverManager.getConnection(url,user,pass);
		//3.sql문장
		String sql ="UPDATE info_tab SET name =?,jumin=?,gender=?,age=?,home=? WHERE tel=? ";
				
		//4.전송객체 얻어오기
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, vo.getName());
		st.setString(2, vo.getJumin());
		st.setString(3, vo.getGender());
		st.setInt(4, vo.getAge());
		st.setString(5, vo.getHome());
		st.setString(6, vo.getTel());
		
		//5.전송
		st.executeUpdate();
		//6.닫기
		st.close();
	}finally {
		con.close();
	}
		

	
		
	}
	@Override
	public ArrayList<InfoVO> selectAll() throws SQLException {
		Connection con = null;
		try {
		//jdbc연동하기
		//1.Connection얻어오기
		con = DriverManager.getConnection(url,user,pass);
		
		//3.sql만들기
		String sql = "SELECT * FROM info_tab";
		
		PreparedStatement st = con.prepareStatement(sql);
				
		//5.전송
		//	-executeUpdate(): INSERT,DELETE,UPDATE
		//	-executeQuery():  SELECT
		ResultSet rs = st.executeQuery();
		ArrayList<InfoVO> list = new ArrayList<InfoVO>();//몇줄이 들어올지 모르니 어레이리스트로 만들어줌
		while(rs.next()) {
			InfoVO vo = new InfoVO();//하나의 덩어리로 만듦
			vo.setName(rs.getString("NAME"));
			vo.setJumin(rs.getString("JUMIN"));
			vo.setTel(rs.getString("TEL"));
			vo.setGender(rs.getString("GENDER"));
			vo.setAge(rs.getInt("AGE"));
			vo.setHome(rs.getString("HOME"));
			list.add(vo);
		}
		
		st.close();
		rs.close();
		return list;
		}finally{
		con.close();
		}
		
		

	}

	@Override
	public void delete(String tel) throws SQLException {
		Connection con = null;
		try {
		InfoVO  vo = new InfoVO();
		
		//2.Connection 얻어오기
		con = DriverManager.getConnection(url,user,pass);
		//3.SQL만들기
		String sql = "DELETE  FROM info_tab WHERE tel= ?";
		PreparedStatement st = con.prepareStatement(sql);//이건 sql을 끌고 들어가야
		//4.전송객체 얻어오기
		
		st.setString(1, tel);
		st.executeUpdate();//위에 먼저 끌고 갔으니 sql을 끌고가면 안됨
		//5.전송
		
		ResultSet rs = st.executeQuery();
			
		//7.닫기
		st.close();
		rs.close();

		}finally {
			con.close();
		}

	}
	@Override
	public InfoVO selectBytel(String tel) throws SQLException {
		Connection con = null;
		try {
		InfoVO  vo = new InfoVO();
		
		//2.Connection 얻어오기
		con = DriverManager.getConnection(url,user,pass);
		//3.SQL만들기
		String sql = "SELECT * FROM info_tab WHERE tel= ?";
		
		//4.전송객체 얻어오기
		PreparedStatement st = con.prepareStatement(sql);//이건 sql을 끌고 들어가야함
		st.setString(1, tel);
		st.executeUpdate();//위에 먼저 끌고 갔으니 sql을 끌고가면 안됨
		//5.전송
		
		ResultSet rs = st.executeQuery();
		
		//6.결과처리
		if(rs.next()) {
			vo.setName(rs.getString("NAME"));
			vo.setJumin(rs.getString("JUMIN"));
			vo.setAge(rs.getInt("AGE"));
			vo.setGender(rs.getString("GENDER"));
			vo.setHome(rs.getString("HOME"));
		}
		
		//7.닫기
		st.close();
		rs.close();
		return vo;
		}finally {
			con.close();
		}
		
		
	}

}
