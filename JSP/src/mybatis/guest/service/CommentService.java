package mybatis.guest.service;

import java.util.*;

import mybatis.guest.model.Comment;
import mybatis.guest.session.CommentRepository;

public class CommentService {
	
	private static CommentService service;
	
	public static CommentService getInstance(){
		if( service == null) service = new CommentService();
		return service;
	}
	private CommentService() {};//생성되면 자동으로 public으로 생성자가 만들어 지는데 그것을 막고자 private로 만든다.
	
	CommentRepository repo = new CommentRepository();
	
	//목록보기
	public List<Comment> selectComment() {
		return repo.selectComment();//받은놈을 고스란히 보내버림
	}
	
	
	//입력하기
	public Integer insertComment(Comment c) {
		return repo.insertComment(c); //몇개의 행을 입력했는지 받아옴
	}
	
	public Comment selectCommentByPrimaryKey(long commentNo) {
		return repo.selectCommentByPK(commentNo);
	}
	 
	public Integer deleteComment(int commentNo) {
		return repo.deleteComment(commentNo);
	}
	
	public Integer modifyComment(Comment c) {
		return repo.modifyComment(c);
	}

}