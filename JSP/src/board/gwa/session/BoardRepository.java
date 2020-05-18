package board.gwa.session;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.gwa.model.Board;
import board.model.BoardRec;


public class BoardRepository {
	
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

	public int deleteBoard(Board c) {
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		try {
			int result = sqlSess.delete("BoardMapper.deleteBoard",c);
			if(result>0) sqlSess.commit();//반드시 입력을 하고 나서 커밋을 해줘야함
			else sqlSess.rollback();//실수했다면 롤벡
			
			return result;
		}finally {
			sqlSess.close();			
		}
		
	}

	
	

}
