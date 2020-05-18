package mybatis.guest.model;

import java.io.Serializable;

public class Comment implements Serializable{//직렬화를 해줘야 통신이 가능했었는데 지금은 안해줘도 된다.

	private long commentNo;
	private String userId;
	private String commentContent;
	private String regDate;
	
	public long getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(long commentNo) {
		this.commentNo = commentNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
}
