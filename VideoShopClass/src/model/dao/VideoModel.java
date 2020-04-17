package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.VideoDao;
import model.vo.Video;

public class VideoModel implements VideoDao{
	String url;
	String user;
	String pass;
	public VideoModel() throws Exception{
		

		// 1. 드라이버로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		url = "jdbc:oracle:thin:@192.168.0.79:1521:orcl";
		user = "ryu";
		pass = "1234";
		
	}
	
	
	public void insertVideo(Video vo, int count) throws Exception{
		Connection con = null;
		try {
			
			// 2. Connection 연결객체 얻어오기
			con = DriverManager.getConnection(url,user,pass);
			// 3. sql 문장 만들기
			String sql = " INSERT INTO video(num,title,detail,genre,director,actor,stock) "
					+ " VALUES(V_SEQ.NEXTVAL,?,?,?,?,?,?) ";
			// 4. sql 전송객체 (PreparedStatement)	
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, vo.getVideoName());
			st.setString(2, vo.getExp());
			st.setString(3, vo.getGenre());
			st.setString(4, vo.getDirector());
			st.setString(5, vo.getActor());
			st.setInt(6,count);
			
			
			
			for(int i=0;i<count;i++) {
				int rs = st.executeUpdate();
				// 5. sql 전송
			}
				
			// 6. 닫기
				st.close();
		}finally {
			con.close();
		}
	}
	public Video selectByPK(int vnum) throws Exception{
		Video vo = new Video();
		Connection con = null;
		con = DriverManager.getConnection(url,user,pass);
		
		String sql = " SELECT * FROM 비디오테이블  WHERE  비디오 번호 =?";
		
		//해당 비디오번호의 비디오정보를 검색하여 Video 클래스에 각각 멤버변수로 지정
		return vo;
	}

	
	public ArrayList selectVideo(int index,String word) throws Exception{
		
		ArrayList data = new ArrayList();
		Connection con = null;
		try {
		con = DriverManager.getConnection(url,user,pass);
		String[]colName = {"TITLE","ACTOR"};
		
//		String sql = " SELECT 비디오번호,제목,배우 FROM 비디오테이블"
//				+ " WHERE "+ colName[index]+"like '%"+word+"%' " ;
		String sql = " SELECT NUM,TITLE,ACTOR FROM VIDEO "
				+ " WHERE "+ colName[index]+" like '%"+word+"%' " ;
		
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ArrayList a = new ArrayList();
			a.add(rs.getInt("NUM"));
			a.add(rs.getString("TITLE"));
			a.add(rs.getString("ACTOR"));
			data.add(a);
		}
		st.close();
		rs.close();
		}finally {
			con.close();
		}
		
		
		return data;
	}

}
