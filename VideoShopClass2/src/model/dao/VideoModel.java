package model.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.VideoDao;
import model.vo.Video;

public class VideoModel implements VideoDao{
	String url = "jdbc:oracle:thin:@192.168.0.79:1521:orcl";
	String user = "ryu";
	String pass = "1234";

	public VideoModel() throws Exception{
		// 1. 드라이버로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

	}


	public void insertVideo(Video vo, int count) throws Exception{
		Connection con = null;
		try {

			// 2. Connection 연결객체 얻어오기
			con = DriverManager.getConnection(url, user, pass);
			// 3. sql 문장 만들기
			String sql = "INSERT INTO video(num, title, detail, genre, director, actor, stock) VALUES(v_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			// 4. sql 전송객체 (PreparedStatement)		
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, vo.getVideoName());
			st.setString(2, vo.getExp());
			st.setString(3, vo.getGenre());
			st.setString(4, vo.getDirector());
			st.setString(5, vo.getActor());
			st.setString(6, String.valueOf(count));

			for(int i=0; i<count; i++) {
				// 5. sql 전송
				st.executeUpdate();
			}
			// 6. 닫기
			st.close();
		}finally{
			con.close();
		}
	}


	public ArrayList selectVideo(int index, String word) throws Exception{
		ArrayList data = new ArrayList();
		Connection con = null;
		con = DriverManager.getConnection(url, user, pass);
		String[]colName = {"TITLE", "ACTOR"};

		String sql = " SELECT NUM, TITLE, ACTOR " + 
				" FROM VIDEO " + 
				" WHERE " + colName[index] + " like '%" + word + "%'" ;

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);

		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("NUM"));
			temp.add(rs.getString("TITLE"));
			temp.add(rs.getString("ACTOR"));

			data.add(temp);
		}

		return data;//ArrayList의 ArrayList리턴
	}


	public Video selectByPK(int vnum) throws Exception {
		Video vo = new Video();
		Connection con = null;
		con = DriverManager.getConnection(url, user, pass);
		String sql = " SELECT * FROM VIDEO WHERE NUM = ? ";
		// 해당 비디오 번호의 비디오 정보를 검색하여 Video 클래스에 각각 멤버변수로 지정
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, vnum);

		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			vo.setVideoNo(rs.getInt("NUM"));
			vo.setVideoName(rs.getString("TITLE"));
			vo.setExp(rs.getString("DETAIL"));
			vo.setGenre(rs.getString("GENRE"));
			vo.setDirector(rs.getString("DIRECTOR"));
			vo.setActor(rs.getString("ACTOR"));
		}
		return vo;

	}
}
