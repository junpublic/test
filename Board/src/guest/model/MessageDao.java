package guest.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageDao {

	// Single Pattern 
	private static MessageDao instance;
	
	// DB 연결시  관한 변수 
	private static final String 	dbDriver	=	"oracle.jdbc.driver.OracleDriver";
	private static final String		dbUrl		=	"jdbc:oracle:thin:@192.168.0.49:1521:orcl";
	private static final String		dbUser		=	"scott";
	private static final String		dbPass		=	"tiger";
	
	
	
	//--------------------------------------------
	//#####	 객체 생성하는 메소드 
	public static MessageDao	getInstance() throws MessageException
	{
		if( instance == null )
		{
			instance = new MessageDao();
		}
		return instance;
	}
	
	private MessageDao() throws MessageException
	{
	
		try{
			
			/********************************************
				1. 오라클 드라이버를 로딩
					( DBCP 연결하면 삭제할 부분 )
			*/
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch( Exception ex ){
			throw new MessageException("방명록 ) DB 연결시 오류  : " + ex.toString() );	
		}
		
	}
	
	
	/*
	 * 메세지를 입력하는 함수
	 */
	public void insert(Message rec) throws MessageException
	{
		Connection	 		con = null;
		PreparedStatement ps = null;
		try{

			// 1. 연결객체(Connection) 얻어오기
			con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			// 2. sql 문장 만들기
			String sql = "INSERT INTO GuestTB VALUES(seq_messageId_guestTb.NEXTVAL,?,?,?) ";
			
			// 3. 전송객체 얻어오기
			ps = con.prepareStatement(sql);
			ps.setString(1, rec.getGuestName());
			ps.setString(2, rec.getPassword());
			ps.setString(3, rec.getMessage());
			// 4. 전송하기
			ps.executeUpdate();

						
		}catch( Exception ex ){
			throw new MessageException("방명록 ) DB에 입력시 오류  : " + ex.toString() );	
		} finally{
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}
	
	}
	
	/*
	 * 메세지 목록 전체를 얻어올 때
	 */
	public List<Message> selectList() throws MessageException
	{
		Connection	 		con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Message> mList = new ArrayList<Message>();
		boolean isEmpty = true;
		
		try{

			//1.연결객체 얻어오기
			con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			//2.sql 문장 만들기
			String sql = "SELECT * FROM GuestTB";
			//3.전송객체 얻어오기
			ps = con.prepareStatement(sql);
			//4.전송(executeQuery())
			rs=ps.executeQuery();
			//5.결과집합 받기
			while(rs.next()) {//저장된 값이 또 있을때 까지 한다.
				isEmpty = false;//값이 없을 때 false라고 해주기
				Message ms = new Message();//message 객체 생성
				ms.setGuestName(rs.getString("GUEST_NAME"));//이름을 받아서 객체에 저장
				ms.setMessageId(rs.getInt("MESSAGE_ID"));//아이디를 받아서 객체에 저장
				ms.setMessage(rs.getString("MESSAGE"));//메세지를 받아서 객체에 저장
				mList.add(ms);//arrayList에 객체를 저장
				
			}
			
			
			//    while 안에서 isEmpty=false;라고 하기
			
			if( isEmpty ) return Collections.emptyList();
			
			return mList;
			
				
		}catch( Exception ex ){
			throw new MessageException("방명록 ) DB에 목록 검색시 오류  : " + ex.toString() );	
		} finally{
			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}		
	}
	

	/* -------------------------------------------------------
	 * 현재 페이지에 보여울 메세지 목록  얻어올 때
	 */
	public List<Message> selectList(int firstRow, int endRow) throws MessageException
	{
		Connection	 		con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Message> mList = new ArrayList<Message>();
		boolean isEmpty = true;
		
		try{

			//1.연결객체 얻어오기
			con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			//2.sql 문장 만들기
			String sql = " SELECT * " + 
					" FROM GUESTTB " + 
					" WHERE message_id IN(SELECT message_id  " + 
					"    FROM (SELECT rownum AS rnum,message_id  " + 
					"        FROM (SELECT rownum,message_id FROM guesttb ORDER BY message_id DESC)) " + 
					"    WHERE rnum>=? and rnum<=?) " + 
					" ORDER BY message_id DESC ";
			//3.전송객체 얻어오기
			ps = con.prepareStatement(sql);
			ps.setInt(1, firstRow);
			ps.setInt(2, endRow);

			//4.전송(executeQuery())
			rs=ps.executeQuery();
			//5.결과집합 받기
			while(rs.next()) {
				isEmpty = false;
				Message ms = new Message();//message 객체 생성
				ms.setGuestName(rs.getString("GUEST_NAME"));//이름을 받아서 객체에 저장
				ms.setMessageId(rs.getInt("MESSAGE_ID"));//아이디를 받아서 객체에 저장
				ms.setMessage(rs.getString("MESSAGE"));//메세지를 받아서 객체에 저장
				mList.add(ms);
			}
			
			if( isEmpty ) return Collections.emptyList();
			
			return mList;
		}catch( Exception ex ){
			throw new MessageException("방명록 ) DB에 목록 검색시 오류  : " + ex.toString() );	
		} finally{
			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}		
	}
	
	
	
	/* -------------------------------------------------------
	 * 메세지 전체 레코드 수를 검색
	 */
	
	public int getTotalCount() throws MessageException{
		Connection	 		con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;

		try{
			con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			//2.sql 문장 만들기
			String sql = "SELECT COUNT(*) cnt FROM guesttb";
			//3.전송객체 얻어오기
			ps = con.prepareStatement(sql);
			
			
			//4.전송(executeQuery())
			
			rs=ps.executeQuery();
			
			if(rs.next())//두번째부터 값이 있으니 next해줘야함
				count=rs.getInt("cnt");
			
				
			return  count;
			
		}catch( Exception ex ){
			throw new MessageException("방명록 ) DB에 목록 검색시 오류  : " + ex.toString() );	
		} finally{
			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}			
	}
	
	/*
	 * 메세지 번호와 비밀번호에 의해 메세지 삭제
	 */
	public int delete( int messageId, String password ) throws MessageException
	{
		int result = 0;
		Connection	 		con = null;
		PreparedStatement ps = null;
		try{

			//1.연결객체 얻어오기
			con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			//2.sql 문장 만들기
			String sql = "DELETE FROM GuestTB WHERE MESSAGE_ID=? AND PASSWORD=?";
			//3.전송객체 얻어오기
			ps = con.prepareStatement(sql);
			ps.setInt(1,messageId );
			ps.setString(2, password);
			//4.전송(executeQuery())
			result=ps.executeUpdate();
				
			
			return result;//삭제된것을 리턴
			
		}catch( Exception ex ){
			throw new MessageException("방명록 ) DB에 삭제시 오류  : " + ex.toString() );	
		} finally{
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}		
	}
}
