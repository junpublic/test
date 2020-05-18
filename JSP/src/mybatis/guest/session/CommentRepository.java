package mybatis.guest.session;

import java.io.*;
import java.util.*;

import mybatis.guest.model.Comment;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
  
public class CommentRepository  
{
	//	private final String namespace = "CommentMapper";

	private SqlSessionFactory getSqlSessionFactory() {
		
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		SqlSessionFactory sessFactory =  new SqlSessionFactoryBuilder().build(inputStream);
		return sessFactory;
	}
	 

//연결객체 -JDBC:connection
//		-Mybatis:SqlSession 연결을 당담하는 공장을 하나 얻어온다.
	public List<Comment> selectComment() {
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		try {
		List<Comment> list = sqlSess.selectList("CommentMapper.selectComment");//CommentMapper.selectComment를 찾아서 실행
		return list;
		}finally {
		sqlSess.close();//연결을 끊는 것이 아니라 반납하는 개념
		}
	} 
	
	
	//입력
	public Integer insertComment(Comment c) {
		SqlSession sqlSess = getSqlSessionFactory().openSession();//연결객체 얻어옴
		try {
			int result = sqlSess.insert("CommentMapper.insertComment",c);//부르면서 c를 넘겨준다.
			if(result>0) sqlSess.commit();//반드시 입력을 하고 나서 커밋을 해줘야함
			else sqlSess.rollback();//실수했다면 롤벡
				
			return result;
		}finally {
			sqlSess.close();//연결을 끊는 것이 아니라 반납하는 개념 
		}
	}
	
	public Comment selectCommentByPK(long commentNo) {
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		try {
			HashMap map = new HashMap();
			map.put("commentNo",commentNo);
			Comment c = sqlSess.selectOne("CommentMapper.selectCommentByPK",map);
			return c;
		}finally { 
			
			sqlSess.close();
		}
	}
	
	public int deleteComment(int commentNo) {
		SqlSession sqlSess = getSqlSessionFactory().openSession();//연결객체 얻어옴
		try {
			int result = sqlSess.delete("CommentMapper.deleteComment",commentNo);
			if(result>0) sqlSess.commit();//반드시 입력을 하고 나서 커밋을 해줘야함
			else sqlSess.rollback();//실수했다면 롤벡
				
			return result;
		}finally {
			sqlSess.close();//연결을 끊는 것이 아니라 반납하는 개념 
		}
	}
	
	public int modifyComment(Comment c) {
		SqlSession sqlSess = getSqlSessionFactory().openSession();//연결객체 얻어옴
		try {
			int result = sqlSess.delete("CommentMapper.modifyComment",c);
			if(result>0) sqlSess.commit();//반드시 입력을 하고 나서 커밋을 해줘야함
			else sqlSess.rollback();//실수했다면 롤벡
				
			return result;
		}finally {
			sqlSess.close();//연결을 끊는 것이 아니라 반납하는 개념 
		}
	}
	
}

