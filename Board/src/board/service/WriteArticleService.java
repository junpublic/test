package board.service;

import java.text.DecimalFormat;

import board.model.*;

public class WriteArticleService {
	
	private static WriteArticleService instance;
	public static WriteArticleService getInstance()  throws BoardException{
		if( instance == null )
		{
			instance = new WriteArticleService();
		}
		return instance;
	}
	
	public int write( BoardRec rec ) throws BoardException{
		
		BoardDao dao = BoardDao.getInstance();

		// 그룹번호(group_id) 지정
		int groupId = dao.getGroupId();
		rec.setGroupId(groupId);//그룹아이디 넣음
		
		// 순서번호(sequence_no) 지정
		DecimalFormat dformat = new DecimalFormat("0000000000");//숫자 형식을 잡는 포멧
		rec.setSequenceNo( dformat.format(groupId) + "999999");
		//groupId: 1-sequenceNo :0001999999 뒤의 6자리는 9로 체우고 앞의 4자리만 groupId로 바뀜 
		
		
		// DB에 insert
		int article_id = dao.insert(rec);
			
		return article_id;
		
	}
}
